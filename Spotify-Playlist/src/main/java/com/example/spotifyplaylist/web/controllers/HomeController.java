package com.example.spotifyplaylist.web.controllers;

import com.example.spotifyplaylist.security.CurrentUser;
import com.example.spotifyplaylist.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final SongService songService;

    public HomeController(CurrentUser currentUser, SongService songService) {
        this.currentUser = currentUser;
        this.songService = songService;
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
//        model.addAttribute("products", productService.findAll());
//        model.addAttribute("totalPriceOfProducts", productService.getTotalPrice());

        return "home";
    }

}
