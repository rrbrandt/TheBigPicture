/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.rb0812.model;

/**
 *  Cardinal code example.  Model for tool rental.
 * @author Richard
 */
public class Tool extends GsonString {
  
  private String code;
  private String type;
  private String brand;
  private long dailyCharge;
  private boolean weekdayCharge;
  private boolean weekendCharge;
  private boolean holidayCharge;

  public Tool() {
  }

  public Tool(String code, String type, String brand, long dailyCharge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
    this.code = code;
    this.type = type;
    this.brand = brand;
    this.dailyCharge = dailyCharge;
    this.weekdayCharge = weekdayCharge;
    this.weekendCharge = weekendCharge;
    this.holidayCharge = holidayCharge;
  }

  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public String getBrand() {
    return brand;
  }
  public void setBrand(String brand) {
    this.brand = brand;
  }
  /**
   * Get the value of dailyChage.  Stored as integer/pennies.
   *
   * @return the value of dailyCharge
   */
  public long getDailyCharge() {
    return dailyCharge;
  }
  /**
   * Set the value of dailyChage.  Stored as integer/pennies.
   *
   * @param dailyCharge new value of dailyCharge
   */
  public void setDailyCharge(long dailyCharge) {
    this.dailyCharge = dailyCharge;
  }
  public boolean isWeekdayCharge() {
    return weekdayCharge;
  }
  public void setWeekdayCharge(boolean weekdayCharge) {
    this.weekdayCharge = weekdayCharge;
  }
  public boolean isWeekendCharge() {
    return weekendCharge;
  }
  public void setWeekendCharge(boolean weekendCharge) {
    this.weekendCharge = weekendCharge;
  }
  public boolean isHolidayCharge() {
    return holidayCharge;
  }
  public void setHolidayCharge(boolean holidayCharge) {
    this.holidayCharge = holidayCharge;
  }

  @Override
  public String toString() {
    return toGsonString();
  }

    
}
