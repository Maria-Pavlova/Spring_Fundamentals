package com.example.coffeeshop.web.controllers;

import com.example.coffeeshop.models.dto.bindingModels.UserLoginModel;
import com.example.coffeeshop.models.dto.bindingModels.UserRegisterModel;
import com.example.coffeeshop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userModel")
    public void initUserModel(Model model){
        model.addAttribute("userModel", new UserRegisterModel());
    }

    @GetMapping("/register")
    public String getRegister(){
    return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterModel userModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/register";
        }

        userService.registerUser(userModel);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("userLoginModel", new UserLoginModel());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginModel userLoginModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginModel", userLoginModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginModel", bindingResult);
            return "redirect:/users/login";
        }
        if (!userService.isAuthenticateAndLogin(userLoginModel)){
            redirectAttributes.addFlashAttribute("userLoginModel", userLoginModel);
            redirectAttributes.addFlashAttribute("notPresent", true);
            return "redirect:/users/login";
        }
        userService.isAuthenticateAndLogin(userLoginModel);
        return "redirect:/home";

    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

}
