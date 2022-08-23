/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.rb0822;

import com.javasmyths.rb0822.model.RentalAgreement;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Richard
 */
public class ToolServicesTest {

  public ToolServicesTest() {
  }

  @Test
  public void testRentTool() {
    System.out.println("rentTool");
    ApplicationContext context = new ClassPathXmlApplicationContext("storeConfiguration.xml");
    System.out.println("ctx>>" + context);
    ToolServices toolServices = (ToolServices) context.getBean("toolServices");
    Calendar cal = Calendar.getInstance();

    cal.set(2015, Calendar.JULY, 2);
    System.out.println("Rental Agreement:" + toolServices.rentTool("CHNS", 5, 25, cal.getTime()));
  }

  @Test
  public void testIsHoliday() {
    System.out.println("isHoliday");
    ToolServices instance = new ToolServices();
    Calendar cal = Calendar.getInstance();

    //Test Labor Day
    cal.set(2022, Calendar.SEPTEMBER, 5);
    assertTrue(instance.isHoliday(cal));
    cal.set(2022, Calendar.SEPTEMBER, 6);
    assertFalse(instance.isHoliday(cal));
    cal.set(2021, Calendar.SEPTEMBER, 6);
    assertTrue(instance.isHoliday(cal));
    cal.set(2021, Calendar.SEPTEMBER, 13);
    assertFalse(instance.isHoliday(cal));
    cal.set(2020, Calendar.SEPTEMBER, 7);
    assertTrue(instance.isHoliday(cal));

    //Test $th of July
    cal.set(2020, Calendar.JULY, 3);
    assertTrue(instance.isHoliday(cal));
    cal.set(2020, Calendar.JULY, 4);
    assertFalse(instance.isHoliday(cal));
    cal.set(2021, Calendar.JULY, 5);
    assertTrue(instance.isHoliday(cal));
    cal.set(2021, Calendar.JULY, 4);
    assertFalse(instance.isHoliday(cal));
    cal.set(2022, Calendar.JULY, 4);
    assertTrue(instance.isHoliday(cal));

    cal.set(2022, Calendar.MARCH, 23);
    assertFalse(instance.isHoliday(cal));
  }

}
