package com.example.pathfinder.web.controllers;

import com.example.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final RouteService routeService;

    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("mostCommented", routeService.getMostCommented().get(0));
        return "index";

    }
}
