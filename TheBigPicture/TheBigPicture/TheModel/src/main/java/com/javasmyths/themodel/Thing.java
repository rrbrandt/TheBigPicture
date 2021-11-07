/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.themodel;

import java.util.UUID;

/**
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
