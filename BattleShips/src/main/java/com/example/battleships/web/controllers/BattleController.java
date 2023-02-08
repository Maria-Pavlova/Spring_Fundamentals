package com.example.battleships.web.controllers;

import com.example.battleships.models.dto.bindingModels.BattleModel;
import com.example.battleships.security.CurrentUser;
import com.example.battleships.services.BattleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BattleController {
private final BattleService battleService;
    private final CurrentUser currentUser;

    public BattleController(BattleService battleService, CurrentUser currentUser) {
        this.battleService = battleService;
        this.currentUser = currentUser;
    }

    @PostMapping("/battle")
    public String battle(@Valid @ModelAttribute(name = "battleModel") BattleModel battleModel,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("battleModel", battleModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.battleModel", bindingResult);
            return "redirect:/home";
        }
        battleService.fire(battleModel);

        return "redirect:/home";
    }
}
