package com.example.exam.web.controllers;

import com.example.exam.models.dtos.bindingModels.AddOfferModel;
import com.example.exam.security.CurrentUser;
import com.example.exam.services.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;
    private final CurrentUser currentUser;

    public OfferController(OfferService offerService, CurrentUser currentUser) {
        this.offerService = offerService;
        this.currentUser = currentUser;
    }


    @ModelAttribute("offerModel")
    public AddOfferModel offerModel() {
        return new AddOfferModel();
    }

    @GetMapping("/add")
    public String getAddForm() {
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid AddOfferModel offerModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);
            return "redirect:/offers/add";
        }
        offerService.addOffer(offerModel);
        return "redirect:/home";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id){
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        offerService.removeOfferById(id);
        return "redirect:/home";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable Long id) {
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        offerService.buy(id);
        return "redirect:/home";
    }




}
