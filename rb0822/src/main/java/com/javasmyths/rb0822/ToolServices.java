/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.rb0822;

import com.javasmyths.rb0822.model.ApplicationConfig;
import com.javasmyths.rb0822.model.RentalAgreement;
import com.javasmyths.rb0822.model.Tool;
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

  public RentalAgreement rentTool(String toolCode, long dayCount, long discountPercentage, Date checkOutDate) {
    Tool tool = applicationConfig.tools.get(toolCode);
    RentalAgreement rentalAgreement = new RentalAgreement(applicationConfig.tools.get(toolCode));
    rentalAgreement.setRentalDays(dayCount);
    rentalAgreement.setCheckOutDate(checkOutDate);
    rentalAgreement.setDiscountPercent(discountPercentage);
    rentalAgreement.setDueDate(new Date(checkOutDate.getTime() + (24 * 60 * 60 * 1000 * dayCount)));
    rentalAgreement.setFinalCharge(tool.getDailyCharge() * calculateChargeDays(toolCode, checkOutDate, dayCount));
    rentalAgreement.setDiscountAmount((long)((double)rentalAgreement.getFinalCharge() * ((double)rentalAgreement.getDiscountPercent() / 100.0) + 0.005) );
    return rentalAgreement;
  }

  @Override
  public String toString() {
    return applicationConfig.getTools().toString();
  }

  public long calculateChargeDays(String toolCode, Date checkOutDate, long daysToRent) {
    long rentalChargeDays = 0;
    Tool tool = applicationConfig.tools.get(toolCode);
    Calendar startCal = Calendar.getInstance();
    startCal.setTime(checkOutDate);
    Calendar endCal = Calendar.getInstance();
    endCal.setTime(checkOutDate);
    endCal.add(Calendar.DATE, (int) daysToRent);

    while (startCal.getTimeInMillis() <= endCal.getTimeInMillis()) {
      startCal.add(Calendar.DAY_OF_MONTH, 1);

      if (isHoliday(startCal)) {
        if (!tool.isHolidayCharge()) {
          rentalChargeDays++;
        }
      } else {
        if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
          if (!tool.isWeekendCharge()) {
            rentalChargeDays++;
          }
        }
      }
    }

    System.out.println("Rental Charge Days = " + rentalChargeDays);
    return rentalChargeDays;
  }

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

}
