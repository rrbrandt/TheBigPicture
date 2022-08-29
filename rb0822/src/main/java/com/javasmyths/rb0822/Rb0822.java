/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */

package com.javasmyths.rb0822;

import java.util.Calendar;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Set up the singleton container with the tools for testing.
 * 
 * A few assumtions: 
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
      System.out.println("" + toolServices.rentTool("JAKR", 5, 101, new Date(calendar.getTimeInMillis())));
    }
}