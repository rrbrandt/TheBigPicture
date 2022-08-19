/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.rb0812;

import com.javasmyths.rb0812.model.ApplicationConfig;
import com.javasmyths.rb0812.model.RentalAgreement;
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
    RentalAgreement rentalAgreement = new RentalAgreement (applicationConfig.tools.get(toolCode));
    rentalAgreement.setRentalDays(dayCount);
    rentalAgreement.setCheckOutDate(checkOutDate);
    rentalAgreement.setDiscountPercent(discountPercentage);
    return rentalAgreement;
  }
  
  @Override
  public String toString() {
   return applicationConfig.getTools().toString();
  }
}
