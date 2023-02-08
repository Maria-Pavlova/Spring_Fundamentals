package com.example.battleships.web.controllers;

import com.example.battleships.models.dto.bindingModels.AddShipModel;
import com.example.battleships.security.CurrentUser;
import com.example.battleships.services.ShipService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ships")
public class ShipController {
    private final ShipService shipService;
    private final CurrentUser currentUser;

    public ShipController(ShipService shipService, CurrentUser currentUser) {
        this.shipService = shipService;
        this.currentUser = currentUser;
    }

    @ModelAttribute("shipModel")
    public AddShipModel initShipModel(){
        return new AddShipModel();
    }

    @GetMapping("/add")
    public String getAddForm(){
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        return "ship-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddShipModel shipModel,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes){
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("shipModel", shipModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipModel", bindingResult);
            return "redirect:/ships/add";
        }
        shipService.addShip(shipModel);
        return "redirect:/home";
    }
}
