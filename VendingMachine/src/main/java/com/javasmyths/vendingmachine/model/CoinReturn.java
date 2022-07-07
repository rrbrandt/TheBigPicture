/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.vendingmachine.model;

import com.javasmyths.vendingmachine.errors.MakeChangeException;

/**
 * Coin return is just a command.  return the coins in cash in to customer and
 * set cash in to zero.
 * 
 * @author Richard
 */
public class CoinReturn implements Command {

  @Override
  public String execute() throws MakeChangeException {
    StringBuilder stringBuilder = new StringBuilder("");
    VendingMachine vendingMachine = VendingMachine.getInstance();
    stringBuilder.append(vendingMachine.makeChange(vendingMachine.getCashIn()));
    vendingMachine.setCashIn(0);
    return stringBuilder.toString();
  }

}
