package com.mobilele.web;

import com.mobilele.models.dtos.UserLoginDto;
import com.mobilele.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "auth-login";
    }

    @PostMapping("/login")
    public String loginConfirm(UserLoginDto userLoginDto){
       userService.login(userLoginDto);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }


}
