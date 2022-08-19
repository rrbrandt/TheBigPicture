/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.rb0812.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Richard
 */
public class ToolTest {
  
  public ToolTest() {
  }

  @org.junit.jupiter.api.Test
  public void testGson() {
    System.out.println("testGson");
    Tool instance = new Tool();
    instance.setBrand("brand");
    instance.setCode("code");
    instance.setDailyCharge(3141592);
    instance.setType("type");
    instance.setWeekdayCharge(true);
    instance.setWeekendCharge(true);
    instance.setHolidayCharge(true);
    System.out.println(instance.toGsonString());
    assertEquals("{\"code\":\"code\",\"type\":\"type\",\"brand\":\"brand\",\"dailyCharge\":3141592,\"weekdayCharge\":true,\"weekendCharge\":true,\"holidayCharge\":true}", instance.toGsonString());
  }

}
