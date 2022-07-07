/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.vendingmachine.model;

/**
 * represents the total number of coins loaded in a dispenser for a denomination  
 * @author Richard
 */
public class LoadedDenomination extends Denomination {
  private int count;

  /**
   * 
   * @param value
   * @param type 
   */
  public LoadedDenomination(int value, String type) {
    super(value, type);
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public void dispense() {
    if (count > 0) count--;
  }

  @Override
  public String toString() {
    return "{" + "count=" + count + ", value=" + getValue() + '}';
  }

}
