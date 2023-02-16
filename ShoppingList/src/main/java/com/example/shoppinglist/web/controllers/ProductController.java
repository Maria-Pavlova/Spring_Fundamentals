package com.example.shoppinglist.web.controllers;

import com.example.shoppinglist.models.dtos.bindingModels.AddProductModel;
import com.example.shoppinglist.security.CurrentUser;
import com.example.shoppinglist.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final CurrentUser currentUser;

    public ProductController(ProductService productService, CurrentUser currentUser) {
        this.productService = productService;
        this.currentUser = currentUser;
    }

    @ModelAttribute("productModel")
    public AddProductModel productModel(){
        return new AddProductModel();
    }

    @GetMapping("/add")
    public String getAddForm(){

        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        return "product-add";
    }

    @PostMapping("/add")
    public String addProduct(@Valid AddProductModel productModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productModel", productModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productModel", bindingResult);
            return "redirect:/products/add";
        }
        productService.addProduct(productModel);
        return "redirect:/home";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable Long id){
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        productService.buyProduct(id);
        return "redirect:/home";
    }

    @GetMapping("/buyAll")
    public String buyAll(){
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        productService.buyAllProducts();
        return "redirect:/home";
    }


}
