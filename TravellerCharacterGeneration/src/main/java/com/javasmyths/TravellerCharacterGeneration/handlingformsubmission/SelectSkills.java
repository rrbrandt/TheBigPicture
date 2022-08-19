package com.javasmyths.TravellerCharacterGeneration.handlingformsubmission;

import com.javasmyths.TravellerCharacterGeneration.model.Service;
import com.javasmyths.TravellerCharacterGeneration.services.CharacterServices;
import com.javasmyths.TravellerCharacterGeneration.services.Dice;
import com.javasmyths.travellercharactergeneration.model.Characteristics;
import com.javasmyths.travellercharactergeneration.model.TravellerCharacter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SelectSkills {

  Dice dice = new Dice();

  @GetMapping("/selectskills")
  public String greetingForm(@ModelAttribute TravellerCharacter character, Model model) {
    System.out.println("****************************************");
    System.out.println("selectskills - get");
    System.out.println("****************************************");
    model.addAttribute("character", character);
    System.out.println("Character: " + model.getAttribute("character"));
    return "selectservice";
  }

  @PostMapping("/selectskills")
  public String greetingSubmit(@ModelAttribute TravellerCharacter character, Model model) {
    System.out.println("****************************************");
    System.out.println("selectskills - post");
    System.out.println("****************************************");
    model.addAttribute("character", character);
    System.out.println("Character: " + character);
    return "selectskills";
  }

  @RequestMapping(value = "/selectskills", method = RequestMethod.POST, params = "attempt")
  public String reroll(@ModelAttribute TravellerCharacter character, Model model,
          @RequestParam("selectService") String selectService) {
    System.out.println("****************************************");
    System.out.println("selectservice - attempt   selectService = " + selectService);
    System.out.println("****************************************");
    System.out.println("Character: " + character);
    model.addAttribute("character", character);
    return "selectskills";
  }

}
