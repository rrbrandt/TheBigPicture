/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.rb0822;

import com.javasmyths.rb0822.exceptions.InvalidDiscount;
import com.javasmyths.rb0822.exceptions.InvalidRentalDays;
import com.javasmyths.rb0822.model.RentalAgreement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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
  public void testRentBasicTestTool() {
    System.out.println("************************************************************");
    System.out.println("rentTool (custom)");
    ApplicationContext context = new ClassPathXmlApplicationContext("storeConfiguration.xml");
    System.out.println("ctx>>" + context);
    ToolServices toolServices = (ToolServices) context.getBean("toolServices");
    Calendar cal = Calendar.getInstance();

    cal.set(2015, Calendar.JULY, 2);
    try {
      RentalAgreement rentalAgreement = toolServices.rentTool("CHNS", 5, 25, cal.getTime());
      System.out.println(rentalAgreement.toString());
      System.out.println(rentalAgreement.toGsonString());
      assertEquals("{\"tool\":{\"code\":\"CHNS\",\"type\":\"Chainsaw\",\"brand\":\"Stihl\",\"dailyCharge\":149,\"weekdayCharge\":true,\"weekendCharge\":false,\"holidayCharge\":true},\"rentalDays\":5,\"checkOutDate\":\"07/02/15\",\"dueDate\":\"07/07/15\",\"preDiscountCharge\":447,\"discountPercent\":25,\"discountAmount\":111,\"finalCharge\":336}",
              rentalAgreement.toGsonString());
    } catch (InvalidDiscount | InvalidRentalDays ex) {
      fail("exception should not be thrown");
    }
  }

  @Test
  public void testInvlidRentalDays() {
    System.out.println("************************************************************");
    System.out.println("rentTool (custom - invalid rental days)");
    ApplicationContext context = new ClassPathXmlApplicationContext("storeConfiguration.xml");
    System.out.println("ctx>>" + context);
    ToolServices toolServices = (ToolServices) context.getBean("toolServices");
    Calendar cal = Calendar.getInstance();
    cal.set(2015, Calendar.JULY, 2);
    
    try {
      RentalAgreement rentalAgreement = toolServices.rentTool("CHNS", 0, 25, cal.getTime());
      System.out.println(rentalAgreement.toString());
      System.out.println(rentalAgreement.toGsonString());
      assertEquals("{\"tool\":{\"code\":\"CHNS\",\"type\":\"Chainsaw\",\"brand\":\"Stihl\",\"dailyCharge\":149,\"weekdayCharge\":true,\"weekendCharge\":false,\"holidayCharge\":true},\"rentalDays\":5,\"checkOutDate\":\"07/02/15\",\"dueDate\":\"07/07/15\",\"preDiscountCharge\":447,\"discountPercent\":25,\"discountAmount\":111,\"finalCharge\":336}",
              rentalAgreement.toGsonString());
      fail("exception should not be thrown");
    } catch (InvalidDiscount ex) {
      fail("This exception should not be thrown.");
    } catch (InvalidRentalDays ex) {
      assertTrue(true);
    }
  }

  @Test
  public void testRentTest1() {
    System.out.println("************************************************************");
    System.out.println("testRentTest1");
    ApplicationContext context = new ClassPathXmlApplicationContext("storeConfiguration.xml");
    ToolServices toolServices = (ToolServices) context.getBean("toolServices");

    Calendar cal = Calendar.getInstance();
    cal.set(2015, Calendar.SEPTEMBER, 2);

    try {
      RentalAgreement rentalAgreement = toolServices.rentTool("JAKR", 5, 101, cal.getTime());
      System.out.println(rentalAgreement.toString());
      System.out.println(rentalAgreement.toGsonString());
      assertEquals("{\"tool\":{\"code\":\"CHNS\",\"type\":\"Chainsaw\",\"brand\":\"Stihl\",\"dailyCharge\":149,\"weekdayCharge\":true,\"weekendCharge\":false,\"holidayCharge\":true},\"rentalDays\":5,\"checkOutDate\":\"07/02/15\",\"dueDate\":\"07/07/15\",\"preDiscountCharge\":0,\"discountPercent\":25,\"discountAmount\":111,\"finalCharge\":447}",
              rentalAgreement.toGsonString());
      fail("exception was not thrown");
    } catch (InvalidDiscount ex) {
      System.out.println("Invalid discount");
      assertTrue(true);
    } catch (InvalidRentalDays ex) {
      fail("exception should not be thrown");
    }
  }

  @Test
  public void testRentTest2() {
    System.out.println("************************************************************");
    System.out.println("testRentTest2");
    ApplicationContext context = new ClassPathXmlApplicationContext("storeConfiguration.xml");
    ToolServices toolServices = (ToolServices) context.getBean("toolServices");

    Calendar cal = Calendar.getInstance();
    cal.set(2020, Calendar.JULY, 2);

    try {
      RentalAgreement rentalAgreement = toolServices.rentTool("LADW", 3, 10, cal.getTime());
      System.out.println(rentalAgreement.toString());
      System.out.println(rentalAgreement.toGsonString());
      assertEquals("{\"tool\":{\"code\":\"LADW\",\"type\":\"Ladder\",\"brand\":\"Werner\",\"dailyCharge\":199,\"weekdayCharge\":true,\"weekendCharge\":true,\"holidayCharge\":false},\"rentalDays\":3,\"checkOutDate\":\"07/02/20\",\"dueDate\":\"07/05/20\",\"preDiscountCharge\":398,\"discountPercent\":10,\"discountAmount\":39,\"finalCharge\":359}",
              rentalAgreement.toGsonString());
    } catch (InvalidDiscount | InvalidRentalDays ex) {
      fail("exception should not be thrown");
    }
  }

  @Test
  public void testRentTest3() {
    System.out.println("************************************************************");
    System.out.println("testRentTest3");
    ApplicationContext context = new ClassPathXmlApplicationContext("storeConfiguration.xml");
    ToolServices toolServices = (ToolServices) context.getBean("toolServices");

    Calendar cal = Calendar.getInstance();
    cal.set(2015, Calendar.JULY, 2);

    try {
      RentalAgreement rentalAgreement = toolServices.rentTool("CHNS", 5, 25, cal.getTime());
      System.out.println(rentalAgreement.toString());
      assertEquals("{\"tool\":{\"code\":\"CHNS\",\"type\":\"Chainsaw\",\"brand\":\"Stihl\",\"dailyCharge\":149,\"weekdayCharge\":true,\"weekendCharge\":false,\"holidayCharge\":true},\"rentalDays\":5,\"checkOutDate\":\"07/02/15\",\"dueDate\":\"07/07/15\",\"preDiscountCharge\":447,\"discountPercent\":25,\"discountAmount\":111,\"finalCharge\":336}",
              rentalAgreement.toGsonString());
    } catch (InvalidDiscount | InvalidRentalDays ex) {
      fail("exception should not be thrown");
    }
  }

  @Test
  public void testRentTest4() {
    System.out.println("************************************************************");
    System.out.println("testRentTest4");
    ApplicationContext context = new ClassPathXmlApplicationContext("storeConfiguration.xml");
    ToolServices toolServices = (ToolServices) context.getBean("toolServices");

    Calendar cal = Calendar.getInstance();
    cal.set(2015, Calendar.SEPTEMBER, 3);

    try {
      RentalAgreement rentalAgreement = toolServices.rentTool("JAKD", 6, 0, cal.getTime());
      System.out.println(rentalAgreement.toString());
      System.out.println(rentalAgreement.toGsonString());
      assertEquals("{\"tool\":{\"code\":\"JAKR\",\"type\":\"Jackhammer\",\"brand\":\"DeWalt\",\"dailyCharge\":299,\"weekdayCharge\":true,\"weekendCharge\":false,\"holidayCharge\":false},\"rentalDays\":6,\"checkOutDate\":\"09/03/15\",\"dueDate\":\"09/09/15\",\"preDiscountCharge\":897,\"discountPercent\":0,\"discountAmount\":0,\"finalCharge\":897}",
              rentalAgreement.toGsonString());
    } catch (InvalidDiscount | InvalidRentalDays ex) {
      fail("exception should not be thrown");
    }
  }

  @Test
  public void testRentTest5() {
    System.out.println("************************************************************");
    System.out.println("testRentTest5");
    ApplicationContext context = new ClassPathXmlApplicationContext("storeConfiguration.xml");
    ToolServices toolServices = (ToolServices) context.getBean("toolServices");

    Calendar cal = Calendar.getInstance();
    cal.set(2015, Calendar.JULY, 2);

    try {
      RentalAgreement rentalAgreement = toolServices.rentTool("JAKR", 9, 0, cal.getTime());
      System.out.println(rentalAgreement.toString());
      System.out.println(rentalAgreement.toGsonString());
      assertEquals("{\"tool\":{\"code\":\"JAKD\",\"type\":\"Jackhammer\",\"brand\":\"Ridged\",\"dailyCharge\":299,\"weekdayCharge\":true,\"weekendCharge\":false,\"holidayCharge\":false},\"rentalDays\":9,\"checkOutDate\":\"07/02/15\",\"dueDate\":\"07/11/15\",\"preDiscountCharge\":1495,\"discountPercent\":0,\"discountAmount\":0,\"finalCharge\":1495}",
              rentalAgreement.toGsonString());
    } catch (InvalidDiscount | InvalidRentalDays ex) {
      fail("exception should not be thrown");
    }
  }

  @Test
  public void testRentTest6() {
    System.out.println("************************************************************");
    System.out.println("testRentTest6");
    ApplicationContext context = new ClassPathXmlApplicationContext("storeConfiguration.xml");
    ToolServices toolServices = (ToolServices) context.getBean("toolServices");

    Calendar cal = Calendar.getInstance();
    cal.set(2020, Calendar.JULY, 2);

    try {
      RentalAgreement rentalAgreement = toolServices.rentTool("JAKR", 4, 50, cal.getTime());
      System.out.println(rentalAgreement.toString());
      System.out.println(rentalAgreement.toGsonString());
      assertEquals("{\"tool\":{\"code\":\"JAKD\",\"type\":\"Jackhammer\",\"brand\":\"Ridged\",\"dailyCharge\":299,\"weekdayCharge\":true,\"weekendCharge\":false,\"holidayCharge\":false},\"rentalDays\":4,\"checkOutDate\":\"07/02/20\",\"dueDate\":\"07/06/20\",\"preDiscountCharge\":299,\"discountPercent\":50,\"discountAmount\":149,\"finalCharge\":150}",
              rentalAgreement.toGsonString());
    } catch (InvalidDiscount | InvalidRentalDays ex) {
      fail("exception should not be thrown");
    }
  }

  @Test
  public void testIsHoliday() {
    System.out.println("************************************************************");
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
    cal.set(2015, Calendar.SEPTEMBER, 7);
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
