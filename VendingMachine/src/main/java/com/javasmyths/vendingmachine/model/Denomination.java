/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.vendingmachine.model;

/**
 * all values stored as pennies.
 * 
 * @author Richard
 */
public class Denomination {
  
  private int value;
  private String type;

  public Denomination(int value, String type) {
    this.value = value;
    this.type = type;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Denomination{" + "value=" + value + ", type=" + type + '}';
  }

}
