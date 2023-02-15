package com.example.musicdb.web.controllers;

import com.example.musicdb.models.dtos.bindingModels.AddAlbumModel;
import com.example.musicdb.security.CurrentUser;
import com.example.musicdb.services.AlbumService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;
    private final CurrentUser currentUser;

    public AlbumController(AlbumService albumService, CurrentUser currentUser) {
        this.albumService = albumService;
        this.currentUser = currentUser;
    }

    @ModelAttribute("addAlbumModel")
    public AddAlbumModel addAlbumModel() {
        return new AddAlbumModel();
    }

    @GetMapping("/add")
    public String getAdd(){
        if (currentUser.isAnonymous()){
            return "redirect:/";
        }
        return "add-album";
    }
    @PostMapping("/add")
    public String addAlbum(@Valid AddAlbumModel addAlbumModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if (currentUser.isAnonymous()){
            return "redirect:/";
        }
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addAlbumModel", addAlbumModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addAlbumModel", bindingResult);
            return "redirect:/albums/add";
        }
        albumService.addAlbum(addAlbumModel);
        return "redirect:/home";
    }

    @GetMapping("/delete{id}")
    public String deleteAlbum(@PathVariable Long id){
        if (currentUser.isAnonymous()){
            return "redirect:/";
        }
        albumService.deleteAlbum(id);
        return "redirect:/home";
    }
}
