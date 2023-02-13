package com.example.spotifyplaylist.web.controllers;

import com.example.spotifyplaylist.models.dtos.bindingModels.AddSongModel;
import com.example.spotifyplaylist.services.SongService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/songs")
public class SongController {
private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @ModelAttribute("addSongModel")
    public AddSongModel addSongModel(){
        return new AddSongModel();
    }

    @GetMapping("/add")
    public String getAddForm(){
        return "song-add";
    }

    @PostMapping("/add")
    public String addProduct(@Valid AddSongModel addSongModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addSongModel", addSongModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addSongModel", bindingResult);
            return "redirect:/songs/add";
        }
        songService.addSong(addSongModel);
        return "redirect:/home";
    }
}
