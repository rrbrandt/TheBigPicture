/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */

package com.javasmyths.rb0822;

import com.javasmyths.rb0822.exceptions.InvalidDiscount;
import com.javasmyths.rb0822.exceptions.InvalidRentalDays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Set up the singleton container with the tools for testing.
 * 
 * A few assumptions: 
 * 
 * @author Richard
 */
@Component
public class Rb0822 {

    public static void main(String[] args) {
      System.out.println("With no tools, there wouldnt be anything.");
      ApplicationContext context = new ClassPathXmlApplicationContext("storeConfiguration.xml");
      ToolServices toolServices = (ToolServices)context.getBean("toolServices");
      System.out.println("toolServices tools = " + toolServices.toString());
      
      System.out.println("****************************************");
      System.out.println("Rent a tool");
      Calendar calendar = Calendar.getInstance();
      calendar.set(2015, 9, 3);
      try {
        System.out.println("" + toolServices.rentTool("JAKR", 5, 101, new Date(calendar.getTimeInMillis())));
      } catch (InvalidDiscount ex) {
        Logger.getLogger(Rb0822.class.getName()).log(Level.SEVERE, null, ex);
      } catch (InvalidRentalDays ex) {
        Logger.getLogger(Rb0822.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
}