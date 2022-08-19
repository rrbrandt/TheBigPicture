/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.TravellerCharacterGeneration.services;

import com.javasmyths.travellercharactergeneration.model.TravellerCharacter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Richard
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiceTest {
  @Autowired
  private TravellerCharacter travellerCharacter;
  
  public DiceTest() {
  }
 

  @Test
  public void testRoleDie() {
    System.out.println("roleDie");
//    Dice instance = new Dice();
//    int result = instance.roleDie();
//    assertTrue(result >= 1 && result <= 6);
  }

  @Test
  public void testRole2Dice() {
    System.out.println("role2Dice");
//    Dice instance = new Dice();
//    int result = instance.roleDie();
//    assertTrue(result >= 2 && result <= 12);
  }
  
}
