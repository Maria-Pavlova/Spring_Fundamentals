package com.example.battleships.web.controllers;

import com.example.battleships.models.dto.bindingModels.BattleModel;
import com.example.battleships.security.CurrentUser;
import com.example.battleships.services.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {
    private final ShipService shipService;
    private final CurrentUser currentUser;

    public HomeController(ShipService shipService, CurrentUser currentUser) {
        this.shipService = shipService;
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String index(){
        if (currentUser.isLoggedIn()){
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model){

        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        model.addAttribute("attacker", shipService.findAllShipsOwnedByAttacker());
        model.addAttribute("defender", shipService.findAllShipsOwnedByDefender());
        model.addAttribute("allShips", shipService.findAllShips());
        return "home";
    }

    @ModelAttribute("battleModel")
    public BattleModel initBattle(){
        return new BattleModel();
    }
}
