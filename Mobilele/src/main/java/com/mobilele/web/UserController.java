package com.mobilele.web;

import com.mobilele.models.dtos.UserLoginDto;
import com.mobilele.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
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
    public UserLoginDto userModel(){
        return new UserLoginDto();
    }
    @GetMapping("/login")
    public String getLogin() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDto userModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/login";
        }
        if (!userService.isAuthenticate(userModel)){
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("notPresent", true);
            return "redirect:/users/login";
        }
        userService.login(userModel);
        return "redirect:/";


    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }


}
