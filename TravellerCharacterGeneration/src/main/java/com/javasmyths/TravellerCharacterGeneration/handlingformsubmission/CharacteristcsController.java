package com.javasmyths.TravellerCharacterGeneration.handlingformsubmission;

import com.javasmyths.travellercharactergeneration.model.Characteristics;
import com.javasmyths.travellercharactergeneration.model.TravellerCharacter;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CharacteristcsController {
  @Resource(name = "TravellerCharacter")
  TravellerCharacter travellerCharacter;

  @GetMapping("/characteristics")
  public String greetingForm(@ModelAttribute TravellerCharacter character, Model model) {
    System.out.println("****************************************");
    System.out.println("characteristics - get");
    System.out.println("****************************************");
    System.out.println("Character: " + travellerCharacter);
    travellerCharacter.setCharacteristics(new Characteristics());
    model.addAttribute("character", travellerCharacter);
    return "characteristics";
  }

  @PostMapping("/characteristics")
  public String greetingSubmit(@ModelAttribute TravellerCharacter character, Model model) {
    System.out.println("****************************************");
    System.out.println("characteristics - post");
    System.out.println("****************************************");
    System.out.println("Character: " + travellerCharacter);
    model.addAttribute("acceptButton", "display");
    model.addAttribute("attemptButton", "display");
    model.addAttribute("continueButton", "hidden");
    return "selectservice";
  }

  @RequestMapping(value = "/characteristics", method = RequestMethod.POST, params = "ReRoll")
  public String reroll(@ModelAttribute TravellerCharacter character, Model model) {
    System.out.println("****************************************");
    System.out.println("characteristics - ReRoll");
    System.out.println("****************************************");
    Characteristics characteristics = new Characteristics();
    travellerCharacter.setCharacteristics(characteristics);
    System.out.println("Character: " + character);
    return "characteristics";
  }

}