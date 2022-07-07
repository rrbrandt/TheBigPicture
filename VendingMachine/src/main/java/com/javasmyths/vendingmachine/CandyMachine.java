/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.vendingmachine;

import com.javasmyths.vendingmachine.errors.MakeChangeException;
import com.javasmyths.vendingmachine.model.ServiceMachine;
import com.javasmyths.vendingmachine.model.CoinReturn;
import com.javasmyths.vendingmachine.model.Command;
import com.javasmyths.vendingmachine.model.Item;
import com.javasmyths.vendingmachine.model.MoneyIn;
import com.javasmyths.vendingmachine.model.VendingMachine;
import java.util.Scanner;

/**
 *
 * @author Richard
 */
public class CandyMachine {

  /**
   * This is the PSVM to run the candy machine in an Add HOC kind of way.  
   * Commands are read from STD-IN and the machine and results are sent to STD-OUT
   * Examples:
   * SERVICE Q-1, D-1, N-1
   * SERVICE PUT-A-65-30 PUT-B-100-15 PUT-C-150-10
   * Q, Q, Q, Q, GET-A
   * A Q D
   * Q, Q, Q, Q, GET-A
   * A Transaction aborted, not enough change.
   * 
   * 
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    while (true) {
      Scanner scanner = new Scanner(System.in);

      while (true) {
        String[] tokens = scanner.nextLine().split("[ ,]+");
        String vendingOutput = processCostomerRequest(tokens);
        System.out.println(vendingOutput);
        System.out.println("CandyMachineState = " + VendingMachine.getInstance());
      }
    }
  }

  /**
   * Break the input process
   *
   * @param tokens
   * @return
   */
  public static String processCostomerRequest(String[] tokens) {
    StringBuilder stringBuilder = new StringBuilder("");
    Command command = null;

    if ((tokens != null)) {
      for (String token : tokens) {
        switch (token) {
          case "DOLLAR":
            command = new MoneyIn(100, "Dollar");
            break;
          case "Q":
            command = new MoneyIn(25, "Quarter");
            break;
          case "D":
            command = new MoneyIn(10, "Dime");
            break;
          case "N":
            command = new MoneyIn(5, "nickel");
            break;
          case "GET-A":
          case "GET-B":
          case "GET-C":
            command = (Command) VendingMachine.getInstance().getItems().get(token.substring(token.indexOf('-') + 1));
            break;
          case "COIN-RETURN":
            command = new CoinReturn();
            break;
          case "SERVICE":
            command = new ServiceMachine(tokens);
            break;
          default:
            break;

        }
        
        try {
          stringBuilder.append(command.execute());
        } catch (MakeChangeException mce) {
          System.out.println("");
        }
        if (token.startsWith("SERVICE")) break;
      }
    }

    return stringBuilder.toString();
  }

}
