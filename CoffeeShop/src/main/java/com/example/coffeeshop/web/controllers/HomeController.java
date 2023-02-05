package com.example.coffeeshop.web.controllers;

import com.example.coffeeshop.models.dto.viewModels.OrderViewModel;
import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class HomeController {
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model){
        List<OrderViewModel> orders = orderService.findAllByPriceDesc();
        model.addAttribute("orders", orders);
        model.addAttribute("totalTime", orders
                .stream()
                .map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
                .reduce(Integer::sum)
                .orElse(0));
        model.addAttribute("ordersByEmployee", userService.findCountOfOrdersByEmployee());

        return "home";
    }
}
