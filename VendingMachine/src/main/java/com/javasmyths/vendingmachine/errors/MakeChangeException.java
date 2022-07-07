/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.vendingmachine.errors;

/**
 * thrown if there isn't enough change in coin dispenser.
 * @author Richard
 */
public class MakeChangeException extends Throwable {

  public MakeChangeException(String message) {
    super(message);
  }
}
