package com.example.exam.web.controllers;

import com.example.exam.security.CurrentUser;
import com.example.exam.services.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final OfferService offerService;


    public HomeController(CurrentUser currentUser, OfferService offerService) {
        this.currentUser = currentUser;
        this.offerService = offerService;
    }


    @GetMapping("/")
    public String index() {
        if (currentUser.isLoggedIn()) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        if (!currentUser.isLoggedIn()) {
            return "redirect:/";
        }

        model.addAttribute("myOffers", offerService.findLoggedUserOffers());
        model.addAttribute("allOffers", offerService.findOtherUsersOffers());
        model.addAttribute("boughtItems", offerService.findBoughtItems());

        return "home";
    }

}
