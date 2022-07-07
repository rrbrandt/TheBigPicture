/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.vendingmachine.model;

import com.javasmyths.vendingmachine.CoinDispenser;
import com.javasmyths.vendingmachine.errors.MakeChangeException;
import java.util.HashMap;

/**
 * So a vending machine has some basic hardware components.  One is the current
 * amount of money's deposited by a customer to purchase an item.  It has slots 
 * of items, each item has a label and cost.
 * 
 * Scope:
 * 1. all dollar amounts are stored as an integer and represents the number of
 *    pennies.  
 * 2. There can be problems that are addressed as error message they are:
 *    2.1 Not enough money deposited to purchase item
 *    2.2 Not enough change available to complete transaction.
 * 
 * @author Richard
 */
public class VendingMachine {
  private CoinDispenser coinDispenser = new CoinDispenser();
  private int cashIn;
  private int bank;
  private static HashMap<String, Item> items = new HashMap();
  private static final VendingMachine vendingMachine = new VendingMachine();

  private VendingMachine() {
  }
  public static VendingMachine getInstance() {
    return vendingMachine;
  }
  
  public int getCashIn() {
    return cashIn;
  }
  public void setCashIn(int cashIn) {
    this.cashIn = cashIn;
  }
  public void addCashIn(int pennies) {
    cashIn += pennies;
  }
  public HashMap getItems() {
    return items;
  }
  public void setItems(HashMap items) {
    this.items = items;
  }
  public CoinDispenser getCoinDispenser() {
    return coinDispenser;
  }
  public void setCoinDispenser(CoinDispenser coinDispenser) {
    this.coinDispenser = coinDispenser;
  }
  String makeChange(int changeRequired) throws MakeChangeException {
    return coinDispenser.makeChange(changeRequired);
  }
  public int getBank() {
    return bank;
  }
  public void setBank(int bank) {
    this.bank = bank;
  }
  
  public void addBank(int cents) {
    bank += cents;
  }

  public void vend(String itemName) {
    Item item = items.get(itemName);
    
    if (item != null) {
      item.setCount(item.getCount() - 1);
    }
  }
  
  @Override
  public String toString() {
    return "VendingMachine{" + "coinDispenser=" + coinDispenser + ", cashIn=" + cashIn + ", bank=" + bank  + ", items=" + items + '}';
  }

  
}
