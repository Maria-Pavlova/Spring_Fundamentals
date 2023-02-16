package com.example.shoppinglist.web.controllers;

import com.example.shoppinglist.security.CurrentUser;
import com.example.shoppinglist.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ProductService productService;

    public HomeController(CurrentUser currentUser, ProductService productService) {
        this.currentUser = currentUser;
        this.productService = productService;
    }

    @GetMapping("/")
    public String index() {
        if (currentUser.isLoggedIn()){
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
       if (!currentUser.isLoggedIn()){
           return "redirect:/";
       }

        model.addAttribute("products", productService.findByCategory());
        model.addAttribute("totalPriceOfProducts", productService.getTotalPrice());

        return "home";
    }

}
