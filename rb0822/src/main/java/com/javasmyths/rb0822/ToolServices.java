/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.rb0822;

import com.javasmyths.rb0822.exceptions.InvalidDiscount;
import com.javasmyths.rb0822.exceptions.InvalidRentalDays;
import com.javasmyths.rb0822.model.ApplicationConfig;
import com.javasmyths.rb0822.model.RentalAgreement;
import com.javasmyths.rb0822.model.Tool;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Richard
 */
public class ToolServices {

  @Autowired
  private ApplicationConfig applicationConfig;

  public ToolServices() {
  }

  /**
   * @param toolCode
   * @param dayCount
   * @param discountPercentage
   * @param checkOutDate
   * @return a valid rental agreement. 
   * @throws InvalidDiscount 
   * @throws com.javasmyths.rb0822.exceptions.InvalidRentalDays 
   */
  public RentalAgreement rentTool(String toolCode, long dayCount, long discountPercentage, Date checkOutDate) throws InvalidDiscount, InvalidRentalDays   {
    Tool tool = applicationConfig.tools.get(toolCode);
    RentalAgreement rentalAgreement = new RentalAgreement(applicationConfig.tools.get(toolCode));
    rentalAgreement.setRentalDays(filterDayCount(dayCount));
    rentalAgreement.setCheckOutDate(checkOutDate);
    rentalAgreement.setDiscountPercent(filterDiscountRate(discountPercentage));
    rentalAgreement.setDueDate(new Date(checkOutDate.getTime() + (24 * 60 * 60 * 1000 * dayCount)));
    rentalAgreement.setPreDiscountCharge(tool.getDailyCharge() * calculateChargeDays(toolCode, checkOutDate, dayCount));
    rentalAgreement.setDiscountAmount((long)((double)rentalAgreement.getPreDiscountCharge() * ((double)rentalAgreement.getDiscountPercent() / 100.0) + 0.005) );
    rentalAgreement.setFinalCharge(rentalAgreement.getPreDiscountCharge() - rentalAgreement.getDiscountAmount());
    return rentalAgreement;
  }

  @Override
  public String toString() {
    return applicationConfig.getTools().toString();
  }

  /**
   * @param toolCode
   * @param checkOutDate
   * @param daysToRent
   * @return the number of days that a tool rental agreement is charged for, some tools you do not have to pay for holidays or weekends.
   */
  public long calculateChargeDays(String toolCode, Date checkOutDate, long daysToRent) {
    long rentalChargeDays = 0;
    Tool tool = applicationConfig.tools.get(toolCode);
    Calendar startCal = Calendar.getInstance();
    startCal.setTime(checkOutDate);
    Calendar endCal = Calendar.getInstance();
    endCal.setTime(checkOutDate);
    endCal.add(Calendar.DATE, (int) daysToRent);

    while (startCal.getTimeInMillis() < endCal.getTimeInMillis()) {
      startCal.add(Calendar.DAY_OF_MONTH, 1);

      if (isHoliday(startCal)) {
        if (tool.isHolidayCharge()) {
          rentalChargeDays++;
        }
      } else {
        if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
          if (tool.isWeekdayCharge()) {
            rentalChargeDays++;
          }
        } else {
          if (tool.isWeekendCharge()) {
            rentalChargeDays++;
          }
        }
      }
    }

    return rentalChargeDays;
  }

  /**
   * @param cal
   * @return true if calendar date is a defined holiday.
   */
  public boolean isHoliday(Calendar cal) {
    boolean isHoliday = false;

    //Labor day is the first monday of the month
    if (cal.get(Calendar.MONTH) == Calendar.SEPTEMBER
            && cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY
            && cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 1) {
      isHoliday = true;
      //The forth is celibrated on closest weekeday.
    } else if (cal.get(Calendar.MONTH) == Calendar.JULY) {
      if (cal.get(Calendar.DAY_OF_MONTH) == 3 && cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
        isHoliday = true;
      } else if (cal.get(Calendar.DAY_OF_MONTH) == 5 && cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
        isHoliday = true;
      } else if (cal.get(Calendar.DAY_OF_MONTH) == 4 && 
              (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)) {
        isHoliday = true;
      }
    }
    
    return isHoliday;
  }

  /**
   * Filter discountPercentage and throw custom exception.
   * @param discountPercentage
   * @return 1-100 if valid
   * @throws InvalidDiscount 
   */
  private long filterDiscountRate(long discountPercentage) throws InvalidDiscount {
    if (discountPercentage < 0 || discountPercentage > 100) {
      throw new InvalidDiscount();
    }
    
    return discountPercentage;
  }

  /**
   * @param dayCount
   * @return day count if greater then 0.  Other wise throw exception.
   */
  private long filterDayCount(long dayCount) throws InvalidRentalDays {
    if (dayCount <= 0 ) {
      throw new InvalidRentalDays();
    }
    
    return dayCount;
  }

}
