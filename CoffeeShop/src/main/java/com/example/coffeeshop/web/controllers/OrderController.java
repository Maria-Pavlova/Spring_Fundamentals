package com.example.coffeeshop.web.controllers;

import com.example.coffeeshop.models.dto.bindingModels.AddOrderModel;
import com.example.coffeeshop.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ModelAttribute("orderModel")
    public AddOrderModel orderModel(){
        return new AddOrderModel();
    }

    @GetMapping("/add")
    public String add(){
        return "order-add";
    }

    @PostMapping("/add")
    public String addOrder(@Valid AddOrderModel orderModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("orderModel", orderModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderModel", bindingResult);
            return "redirect:/orders/add";
        }
        orderService.addOrder(orderModel);
        return "redirect:/home";

    }

    @GetMapping("/ready/{id}")
    public String ready(@PathVariable Long id){
        orderService.readyOrder(id);
        return "redirect:/home";
    }
}
