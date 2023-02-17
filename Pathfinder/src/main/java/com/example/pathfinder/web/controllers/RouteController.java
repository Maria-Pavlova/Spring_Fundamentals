package com.example.pathfinder.web.controllers;

import com.example.pathfinder.models.dto.bindingModels.AddRouteModel;
import com.example.pathfinder.service.RouteService;
import jakarta.validation.Valid;
import org.hibernate.sql.results.graph.collection.internal.BagInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/routes")
public class RouteController {
    private final RouteService routeService;


    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/all")
    public String allRoutes(Model model) {
        model.addAttribute("routes", routeService.findAllRoutes());
        return "routes";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("details", routeService.getDetails(id));
        return "route-details";
    }

    @ModelAttribute("addRouteModel")
    public AddRouteModel addRouteModel() {
        return new AddRouteModel();
    }

    @GetMapping("/add")
    public String add() {
        return "add-route";
    }

    @PostMapping("/add")
    public String addRoute(@Valid AddRouteModel addRouteModel,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addRouteModel", addRouteModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addRouteModel", bindingResult);
            return "redirect:/routes/add";
        }
        routeService.addRoute(addRouteModel);
        return "redirect:/routes/all";
    }

    @GetMapping("/byType/{type}")
    public String getRouteByCategory(@PathVariable String type, Model model) {
        model.addAttribute("routesByType",  this.routeService.findByCategory(type) );
        return "route-byType";
    }
}


