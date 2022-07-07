/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.vendingmachine;

import com.javasmyths.vendingmachine.errors.MakeChangeException;
import com.javasmyths.vendingmachine.model.Denomination;
import com.javasmyths.vendingmachine.model.LoadedDenomination;
import java.util.HashMap;
import java.util.Set;

/**
 * stores coins used to make change when a transaction is completed.  It has 
 * counts for any kind of coin as programmed.
 * 
 * @author Richard
 */
public class CoinDispenser {

  private HashMap<String, LoadedDenomination> coins = new HashMap();

  public HashMap getCoins() {
    return coins;
  }

  public void setCoins(HashMap coins) {
    this.coins = coins;
  }

  /**
   * @return the total amount of cash in cents loaded in coin dispenser.
   */
  public int getTotalCents() {
    int cents = 0;
    Set<String> keys = coins.keySet();
    for (String key : keys) {
      cents += coins.get(key).getCount() * coins.get(key).getValue();
    }
    return cents;
  }
  /**
   * For service, add a count of a type of coin.
   *
   * @param count
   * @param denomination
   */
  public void loadCoin(int count, Denomination denomination) {
    if (denomination != null) {
      LoadedDenomination loadedDenomination = coins.get(denomination.getType());

      if (loadedDenomination != null) {
        loadedDenomination.setCount(loadedDenomination.getCount() + count);
      } else {
        loadedDenomination = new LoadedDenomination(denomination.getValue(), denomination.getType());
        loadedDenomination.setCount(count);
        coins.put(denomination.getType(), loadedDenomination);
      }
    }
  }

  /**
   *
   * @param type
   */
  public void decrementCoin(String type) {
    LoadedDenomination loadedDenomination = coins.get(type);
    if (loadedDenomination != null) {
      loadedDenomination.dispense();
    }
  }

  public String makeChange(int changeRequired) throws MakeChangeException {
    StringBuilder stringBuilder = new StringBuilder("");

    if (changeRequired > getTotalCents()) {
      throw new MakeChangeException ("Transaction aborted, not enough change.");
    }
    while (changeRequired > 0) {
      if (changeRequired >= 25) {
        stringBuilder.append("Q ");
        changeRequired -= 25;
        coins.get("Q").dispense();
      } else if (changeRequired >= 10) {
        stringBuilder.append("D ");
        changeRequired -= 10;
        coins.get("D").dispense();
      } else if (changeRequired >= 5) {
        stringBuilder.append("N ");
        changeRequired -= 10;
        coins.get("N").dispense();
      }
    }

    return stringBuilder.toString();

  }

  @Override
  public String toString() {
    return "CoinDispenser{" + "coins=" + coins + '}';
  }

}
