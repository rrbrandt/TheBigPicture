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
 *
 * @author Richard
 */
@Component
public class Rb0822 {

    public static void main(String[] args) {
      System.out.println("Hello World!");
      ApplicationContext context = new ClassPathXmlApplicationContext("storeConfiguration.xml");
      System.out.println("ctx>>"+context);
      ToolServices toolServices = (ToolServices)context.getBean("toolServices");
      System.out.println("toolServices tools = " + toolServices.toString());
      
      System.out.println("****************************************");
      System.out.println("Rent a tool");
      Calendar calendar = Calendar.getInstance();
      calendar.set(2022, 7, 19);
      System.out.println("" + toolServices.rentTool("CHNS", 7, 0, new Date(calendar.getTimeInMillis())));
    }
}