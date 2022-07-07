/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.vendingmachine.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Richard
 */
public class ServiceMachineTest {
  
  public ServiceMachineTest() {
  }

  @Test
  public void testExecute() {
    System.out.println("execute");
    ServiceMachine instance = new ServiceMachine("".split("[ ,]+"));
    String expResult = "";
    String result = instance.execute();
    assertEquals(expResult, result);
    
    instance = new ServiceMachine("SERVICE Q-100, D-100, N-100".split("[ ,]+"));
    expResult = "";
    result = instance.execute();
    assertEquals(expResult, result);
    
    instance = new ServiceMachine("SERVICE PUT-A-65-30 PUT-B-100-15 PUT-C-150-10".split("[ ,]+"));
    expResult = "";
    result = instance.execute();
    assertEquals(expResult, result);
  }

  @Test
  public void testGetTokens_0args() {
    System.out.println("getTokens");
    ServiceMachine instance = new ServiceMachine("".split("[ ,]+"));
    String[] expResult = null;
    String[] result = instance.getTokens();
    assertEquals(1, result.length);
  }

  @Test
  public void testSetTokens_StringArr() {
    System.out.println("setTokens");
    String[] tokens = null;
    ServiceMachine instance = new ServiceMachine("".split("[ ,]+"));
    instance.setTokens(tokens);
  }

  @Test
  public void testGetTokens_int() {
    System.out.println("getTokens");
    int index = 0;
    ServiceMachine instance = new ServiceMachine("".split("[ ,]+"));
    String expResult = "";
    String result = instance.getTokens(index);
    assertEquals(expResult, result);
  }

  @Test
  public void testSetTokens_int_String() {
    System.out.println("setTokens");
    int index = 0;
    String tokens = "";
    ServiceMachine instance = new ServiceMachine("".split(" "));
    instance.setTokens(index, tokens);
  }
  
}
