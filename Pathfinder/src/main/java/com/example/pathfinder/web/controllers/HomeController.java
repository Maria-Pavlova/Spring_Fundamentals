package com.example.pathfinder.web.controllers;

import com.example.pathfinder.service.PictureService;
import com.example.pathfinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final RouteService routeService;
    private final PictureService pictureService;

    @Autowired
    public HomeController(RouteService routeService, PictureService pictureService) {
        this.routeService = routeService;
        this.pictureService = pictureService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("mostCommented", routeService.getMostCommented().get(0));
        model.addAttribute("pictures", pictureService.findAllUrls());
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    // if use baseController
//    @GetMapping("/")
//    public ModelAndView home(ModelAndView model){
//        MostCommentedRouteView mostCommented = routeService.getMostCommented();
//        model.addObject(mostCommented);
//        return super.view("index", model);
//    }
}
