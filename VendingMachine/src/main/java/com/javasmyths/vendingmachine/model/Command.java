/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.vendingmachine.model;

import com.javasmyths.vendingmachine.errors.MakeChangeException;

/**
 * Using the Command Pattern.  Coins, Items and service requests implement this 
 * interface and the actual required is performed in the implementation.
 * @author Richard
 */
public interface Command {
  public String execute () throws MakeChangeException;
}
