/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.vendingmachine;

import com.javasmyths.vendingmachine.errors.MakeChangeException;
import com.javasmyths.vendingmachine.model.Denomination;
import com.javasmyths.vendingmachine.model.LoadedDenomination;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Richard
 */
public class CoinDispenserTest {

  public CoinDispenserTest() {
  }

  @Test
  public void testGetCoins() {
    System.out.println("getCoins");
    CoinDispenser instance = new CoinDispenser();
    HashMap<String, LoadedDenomination> expResult = new HashMap();
    HashMap result = instance.getCoins();
    assertEquals(expResult, result);
  }

  @Test
  public void testSetCoins() {
    System.out.println("setCoins");
    HashMap coins = null;
    CoinDispenser instance = new CoinDispenser();
    instance.setCoins(coins);
  }

  @Test
  public void testLoadCoin() {
    System.out.println("loadCoin");
    int count = 0;
    Denomination denomination = null;
    CoinDispenser instance = new CoinDispenser();
    instance.loadCoin(count, denomination);
  }

  @Test
  public void testDecrementCoin() {
    System.out.println("decrementCoin");
    String type = "";
    CoinDispenser instance = new CoinDispenser();
    instance.decrementCoin(type);
  }

  @Test
  public void testMakeChange() {
    System.out.println("makeChange");
    int changeRequired = 0;
    CoinDispenser instance = new CoinDispenser();
    String result;

    try {
      result = instance.makeChange(changeRequired);
      assertEquals("", result);
    } catch (MakeChangeException ex) {
      fail("Exception thrown");
    }

    try {
      result = instance.makeChange(100);
      fail("MakeChangeException was not thrown");
    } catch (MakeChangeException ex) {
      assertEquals("Transaction aborted, not enough change.", ex.getMessage());
    }

    instance.loadCoin(100, new Denomination(25, "Q"));
    instance.loadCoin(100, new Denomination(10, "D"));
    instance.loadCoin(100, new Denomination(5, "N"));
    assertEquals("CoinDispenser{coins={Q={count=100, value=25}, D={count=100, value=10}, N={count=100, value=5}}}", instance.toString());

    try {
      result = instance.makeChange(100);
      assertEquals("Q Q Q Q ", result);
    } catch (MakeChangeException ex) {
      fail("Exception thrown");
    }
    assertEquals("CoinDispenser{coins={Q={count=96, value=25}, D={count=100, value=10}, N={count=100, value=5}}}", instance.toString());

    try {
      result = instance.makeChange(65);
      assertEquals("Q Q D N ", result);
    } catch (MakeChangeException ex) {
      fail("Exception thrown");
    }
    assertEquals("CoinDispenser{coins={Q={count=94, value=25}, D={count=99, value=10}, N={count=99, value=5}}}", instance.toString());
    instance = new CoinDispenser();
    instance.loadCoin(1, new Denomination(25, "Q"));
    instance.loadCoin(1, new Denomination(10, "D"));
    instance.loadCoin(1, new Denomination(5, "N"));
    assertEquals("CoinDispenser{coins={Q={count=1, value=25}, D={count=1, value=10}, N={count=1, value=5}}}", instance.toString());

    try {
      result = instance.makeChange(100);
      fail("MakeChangeException was not thrown");
    } catch (MakeChangeException ex) {
      assertEquals("Transaction aborted, not enough change.", ex.getMessage());
    }

  }

  @Test
  public void testToString() {
    System.out.println("toString");
    CoinDispenser instance = new CoinDispenser();
    String expResult = "CoinDispenser{coins={}}";
    String result = instance.toString();
    assertEquals(expResult, result);
  }

}
