/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.rb0822.exceptions;

/**
 *
 * @author Richard
 */
public class InvalidDiscount extends Throwable {

  /**
   * Creates a new instance of <code>InvalidDiscount</code> without detail
   * message.
   */
  public InvalidDiscount() {
  }

  /**
   * Constructs an instance of <code>InvalidDiscount</code> with the specified
   * detail message.
   *
   * @param msg the detail message.
   */
  public InvalidDiscount(String msg) {
    super(msg);
  }
}
