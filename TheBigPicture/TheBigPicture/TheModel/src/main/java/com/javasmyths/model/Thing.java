/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.model;

import java.util.UUID;

/**
 * Date is formatted as defined in config.
 * a start time of zero means the thing has always exist in the past.
 * a end time of zero means the thing will always exist/
 * 
 * @author Richard
 */
public class Thing {
  
  private UUID guid;
  private String startDate;
  private String endDate;

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

}
