/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.vendingmachine.model;

import com.javasmyths.vendingmachine.CoinDispenser;
import com.javasmyths.vendingmachine.model.Command;
import java.util.HashMap;

/**
 *
 * SERVICE Q-100, D-100, N-100
 * SERVICE PUT-A-65-30 PUT-B-100-15 PUT-C-150-10
 * @author Richard
 */
public class ServiceMachine implements Command {
  private String[] tokens;
  
  public ServiceMachine(String[] tokens) {
    this.tokens = tokens;
  }

  @Override
  public String execute() {
    VendingMachine vendingMachine = VendingMachine.getInstance();
    CoinDispenser coinDispenser = vendingMachine.getCoinDispenser();
    
    if ((tokens != null)) {
      for (String token : tokens) {
        if (token.startsWith("Q")) {
          int count = Integer.parseInt(token.substring(2));
          coinDispenser.loadCoin(count, new Denomination(25, "Q"));
        } else if (token.startsWith("D")) {
          int count = Integer.parseInt(token.substring(2));
          coinDispenser.loadCoin(count, new Denomination(10, "D"));
        } else if (token.startsWith("N")) {
          int count = Integer.parseInt(token.substring(2));
          coinDispenser.loadCoin(count, new Denomination(5, "N"));
        } else if (token.startsWith("PUT")) {
          String[] tokens = token.split("[-]+");
          Item item = new Item(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
          HashMap<String, Item> items = vendingMachine.getItems();
          items.put(item.getName(), item);
        }
      }
    }
    
    return "";
  }
  

  public String[] getTokens() {
    return tokens;
  }

  public void setTokens(String[] tokens) {
    this.tokens = tokens;
  }

  public String getTokens(int index) {
    return this.tokens[index];
  }

  public void setTokens(int index, String tokens) {
    this.tokens[index] = tokens;
  }

}
