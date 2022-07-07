/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.vendingmachine.model;

/**
 * Represents a coin put into the machine by a customer to get some candy.  The 
 * command adds the value into Cash In.
 * chasIn bucket.
 * 
 * @author Richard
 */
public class MoneyIn extends Denomination implements Command {

  public MoneyIn(int value, String type) {
    super(value, type);
  }

  @Override
  public String execute() {
    VendingMachine vendingMachine = VendingMachine.getInstance();
    vendingMachine.addCashIn (getValue());
    return "";
  }
  
}
