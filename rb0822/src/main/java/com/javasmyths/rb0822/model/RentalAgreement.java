/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.rb0822.model;

import java.util.Date;

/**
 *
 * @author Richard
 */
public class RentalAgreement extends GsonString {

  private Tool tool;
  private long rentalDays;
  private Date checkOutDate;
  private Date dueDate;
  private long preDiscountCharge;
  private long discountPercent;
  private long discountAmount;
  private long finalCharge;

  public RentalAgreement() {
  }

  public RentalAgreement(Tool tool) {
    this.tool = tool;
  }

  public long getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(long discountAmount) {
    this.discountAmount = discountAmount;
  }

  public long getDiscountPercent() {
    return discountPercent;
  }

  public void setDiscountPercent(long discountPercent) {
    this.discountPercent = discountPercent;
  }
  

  public long getPreDiscountCharge() {
    return preDiscountCharge;
  }

  public void setPreDiscountCharge(long preDiscountCharge) {
    this.preDiscountCharge = preDiscountCharge;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  public Date getCheckOutDate() {
    return checkOutDate;
  }

  public void setCheckOutDate(Date checkOutDate) {
    this.checkOutDate = checkOutDate;
  }
  

  public long getRentalDays() {
    return rentalDays;
  }

  public void setRentalDays(long rentalDays) {
    this.rentalDays = rentalDays;
  }

  public long getFinalCharge() {
    return finalCharge;
  }

  public void setFinalCharge(long finalCharge) {
    this.finalCharge = finalCharge;
  }

  public Tool getTool() {
    return tool;
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  @Override
  public String toString() {
    return toGsonString();
  }
  
}