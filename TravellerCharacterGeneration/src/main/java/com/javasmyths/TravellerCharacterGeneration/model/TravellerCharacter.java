/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.travellercharactergeneration.model;

import com.javasmyths.TravellerCharacterGeneration.model.Service;

/**
 *
 * @author Richard
 */
public class TravellerCharacter {
  
  private String Name;
  private Characteristics characteristics;
  private int age;
  private Service service;
  public TravellerCharacter() {
  }

  public TravellerCharacter(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
  
  public Characteristics getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(Characteristics characteristics) {
    this.characteristics = characteristics;
  }

  public String getName() {
    return Name;
  }

  public void setName(String Name) {
    this.Name = Name;
  }

  public Service getService() {
    return service;
  }

  public void setService(Service service) {
    this.service = service;
  }

  @Override
  public String toString() {
    return "TravellerCharacter{" + "Name=" + Name + ", characteristics=" + characteristics + ", age=" + age + ", service=" + service + '}';
  }

  
}
