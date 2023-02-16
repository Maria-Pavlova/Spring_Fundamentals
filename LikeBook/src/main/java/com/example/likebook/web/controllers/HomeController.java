package com.example.likebook.web.controllers;

import com.example.likebook.security.CurrentUser;
import com.example.likebook.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final PostService postService;

    public HomeController(CurrentUser currentUser, PostService postService) {
        this.currentUser = currentUser;
        this.postService = postService;
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
        model.addAttribute("myPosts", postService.findLoggedUsersPost());
        model.addAttribute("allPosts", postService.findOtherUsersPosts());
        model.addAttribute("allPostsCount", postService.findCountOtherUsersPosts());

        return "home";
    }

}
