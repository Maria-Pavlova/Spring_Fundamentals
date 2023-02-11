package com.example.likebook.web.controllers;

import com.example.likebook.models.dtos.bindingModels.AddPostModel;
import com.example.likebook.security.CurrentUser;
import com.example.likebook.services.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final CurrentUser currentUser;

    public PostController(PostService postService, CurrentUser currentUser) {
        this.postService = postService;
        this.currentUser = currentUser;
    }

    @ModelAttribute("postModel")
    public AddPostModel postModel(){
        return new AddPostModel();
    }

    @GetMapping("/add")
   public String getAddForm(){
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        return "post-add";
    }

    @PostMapping("/add")
    public String addPost(@Valid AddPostModel postModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){

            if (!currentUser.isLoggedIn()){
                return "redirect:/";
            }
            if (bindingResult.hasErrors()){
                redirectAttributes.addFlashAttribute("postModel", postModel);
                redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.postModel", bindingResult);
                return "redirect:/posts/add";
            }
            postService.addPost(postModel);
            return "redirect:/home";
    }


    @GetMapping("/remove/{id}")
    public String buy(@PathVariable Long id){
        postService.removePostById(id);
        return "redirect:/home";
    }

    @GetMapping("/like/{id}")
    public String likePost(@PathVariable Long id){
        postService.likePost(id);
        return "redirect:/home";
    }
}
