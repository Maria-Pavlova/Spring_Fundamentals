package com.example.spotifyplaylist.web.controllers;

import com.example.spotifyplaylist.models.dtos.bindingModels.AddSongModel;
import com.example.spotifyplaylist.security.CurrentUser;
import com.example.spotifyplaylist.services.SongService;
import com.example.spotifyplaylist.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/songs")
public class SongController {
private final SongService songService;
private final UserService userService;
private final CurrentUser currentUser;

    public SongController(SongService songService, UserService userService, CurrentUser currentUser) {
        this.songService = songService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @ModelAttribute("addSongModel")
    public AddSongModel addSongModel(){
        return new AddSongModel();
    }

    @GetMapping("/add")
    public String getAddForm(){
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        return "song-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddSongModel addSongModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addSongModel", addSongModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addSongModel", bindingResult);
            return "redirect:/songs/add";
        }
        songService.addSong(addSongModel);
        return "redirect:/home";
    }

}
