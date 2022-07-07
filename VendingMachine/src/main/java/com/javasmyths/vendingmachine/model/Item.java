/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.vendingmachine.model;

import com.javasmyths.vendingmachine.errors.MakeChangeException;

/**
 * So an Item has a name and a price. All prices are stored as an integer and
 * represents the number of pennies.
 *
 * @author Richard
 */
public class Item implements Command {

  private String name;
  private int cost;
  private int count;
  
  public Item(String name, int cost, int count) {
    this.name = name;
    this.cost = cost;
    this.count = count;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }


  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  @Override
  public String toString() {
    return "Item{" + "name=" + name + ", cost=" + cost + ", count=" + count + '}';
  }

  @Override
  public String execute() throws MakeChangeException {
    StringBuilder stringBuilder = new StringBuilder("");
    VendingMachine vendingMachine = VendingMachine.getInstance();
    int cashIn = vendingMachine.getCashIn();
    
    if (cashIn >= getCost()) {
      stringBuilder.append(getName()).append(" ");
      stringBuilder.append(vendingMachine.makeChange(cashIn - getCost()));
      vendingMachine.setCashIn(0);
      vendingMachine.addBank(getCost());
      vendingMachine.vend(name);
    } else {
      stringBuilder.append("Error, not enough money in for item.");
    }
    
    return stringBuilder.toString();
  }

}
