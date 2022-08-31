package com.javasmyths.TravellerCharacterGeneration.handlingformsubmission;

import com.javasmyths.travellercharactergeneration.model.Characteristics;
import com.javasmyths.travellercharactergeneration.model.TravellerCharacter;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CharacterController {
  TravellerCharacter travellerCharacter;

  @GetMapping("/newcharacter")
  public String greetingForm(Model model) {
    System.out.println("****************************************");
    System.out.println("CharacterController - get");
    System.out.println("****************************************");
    if (travellerCharacter == null) {
      travellerCharacter = new TravellerCharacter();
    }
    model.addAttribute("character", travellerCharacter);
    System.out.println("Character: " + model.getAttribute("character"));
    return "newcharacter";
  }

  @PostMapping("/newcharacter")
  public String greetingSubmit(@ModelAttribute TravellerCharacter character, Model model) {
    System.out.println("****************************************");
    System.out.println("CharacterController - post");
    System.out.println("****************************************");
    if (travellerCharacter == null) {
      travellerCharacter = new TravellerCharacter();
    }
    model.addAttribute("character", character);
    Characteristics characteristic = new Characteristics();
    character.setCharacteristics(characteristic);
    model.addAttribute("characteristics", new Characteristics());
    System.out.println("Character: " + character);
    return "characteristics";
  }

}
