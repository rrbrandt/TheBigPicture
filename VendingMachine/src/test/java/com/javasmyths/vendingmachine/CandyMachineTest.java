/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.vendingmachine;

import com.javasmyths.vendingmachine.model.Denomination;
import com.javasmyths.vendingmachine.model.Item;
import com.javasmyths.vendingmachine.model.VendingMachine;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Richard
 */
public class CandyMachineTest {
  
  public CandyMachineTest() {
  }
  
  @BeforeAll
  public static void setUpClass() {
    VendingMachine instance = VendingMachine.getInstance();
    instance.getItems().put("A", new Item("A", 65, 30));
    instance.getItems().put("B", new Item("B", 100, 15));
    instance.getItems().put("C", new Item("C", 150, 10));

  }
  
  @AfterAll
  public static void tearDownClass() {
  }
  
  @Test
  public void testProcessCostomerRequestNull() {
    System.out.println("processCostomerRequest");
    initialize();
    String[] tokens = null;
    String expResult = "";
    String result = CandyMachine.processCostomerRequest(tokens);
    assertEquals(expResult, result);
  }
  
  @Test
  public void testProcessCostomerRequestExample1() {
    System.out.println("processCostomerRequest");
    initialize();
    String[] tokens = new String("Q Q Q Q GET-B").split("[ ,]+");
    String expResult = "B ";
    String result = CandyMachine.processCostomerRequest(tokens);
    assertEquals(expResult, result);
  }
  
  @Test
  public void testProcessCostomerRequestExample2() {
    System.out.println("processCostomerRequest");
    initialize();
    String[] tokens = new String("Q Q COIN-RETURN").split("[ ,]+");
    String expResult = "Q Q ";
    String result = CandyMachine.processCostomerRequest(tokens);
    assertEquals(expResult, result);
  }
  
  @Test
  public void testProcessCostomerRequestExample3() {
    System.out.println("processCostomerRequest");
    initialize();
    String[] tokens = new String("DOLLAR, GET-A").split("[ ,]+");
    String expResult = "A Q D ";
    String result = CandyMachine.processCostomerRequest(tokens);
    assertEquals(expResult, result);
  }
  
  @Test
  public void testProcessCostomerRequestPerfectChange() {
    System.out.println("processCostomerRequest");
    initialize();
    String[] tokens = new String("Q, Q, D, N, GET-A").split("[ ,]+");
    String expResult = "A ";
    String result = CandyMachine.processCostomerRequest(tokens);
    assertEquals(expResult, result);
  }
  
  public void initialize() {
    VendingMachine instance = VendingMachine.getInstance();
    instance.getItems().put("A", new Item("A", 65, 30));
    instance.getItems().put("B", new Item("B", 100, 15));
    instance.getItems().put("C", new Item("C", 150, 10));
    instance.getCoinDispenser().loadCoin(100, new Denomination(25, "Q"));
    instance.getCoinDispenser().loadCoin(100, new Denomination(10, "D"));
    instance.getCoinDispenser().loadCoin(100, new Denomination(5, "N"));
  }
}

