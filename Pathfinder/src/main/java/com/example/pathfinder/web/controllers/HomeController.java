package com.example.pathfinder.web.controllers;

import com.example.pathfinder.models.dto.view.MostCommentedRouteView;
import com.example.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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

    // if use baseController
//    @GetMapping("/")
//    public ModelAndView home(ModelAndView model){
//        MostCommentedRouteView mostCommented = routeService.getMostCommented();
//        model.addObject(mostCommented);
//        return super.view("index", model);
//    }
}
