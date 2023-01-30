package com.example.pathfinder.web.controllers;

import com.example.pathfinder.models.dto.UserLoginDto;
import com.example.pathfinder.models.dto.UserRegistrationDto;
import com.example.pathfinder.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userRegistrationDto", new UserRegistrationDto());
        return "/register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegistrationDto userRegistrationDto,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDto", bindingResult);
            redirectAttributes.addFlashAttribute("userRegistrationDto", userRegistrationDto);
            return "redirect:/register";
        }

        this.userService.registerUser(userRegistrationDto);
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String getLogin() {
        return "/login";
    }

    @PostMapping("/login")
    public String login(UserLoginDto userLoginDto){
        userService.loginUser(userLoginDto);
        return "redirect:/";
    }

    @GetMapping("users/profile/{username}")
    public String profile(@PathVariable String username, Model model){
        model.addAttribute("userProfile", userService.getUserProfile(username));
        return "profile";


    }

    @GetMapping("/users/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }
}
