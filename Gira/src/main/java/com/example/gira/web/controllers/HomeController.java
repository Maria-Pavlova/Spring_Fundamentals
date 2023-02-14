package com.example.gira.web.controllers;

import com.example.gira.security.CurrentUser;
import com.example.gira.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final TaskService taskService;

    public HomeController(CurrentUser currentUser, TaskService taskService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
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
        model.addAttribute("tasks", taskService.findAll());

        return "home";
    }

}
