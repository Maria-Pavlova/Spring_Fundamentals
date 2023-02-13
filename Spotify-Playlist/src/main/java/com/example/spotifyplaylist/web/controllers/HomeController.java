package com.example.spotifyplaylist.web.controllers;

import com.example.spotifyplaylist.security.CurrentUser;
import com.example.spotifyplaylist.services.HomeService;
import com.example.spotifyplaylist.services.SongService;
import com.example.spotifyplaylist.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final SongService songService;
    private final UserService userService;
    private final HomeService homeService;

    public HomeController(CurrentUser currentUser, SongService songService, UserService userService, HomeService homeService) {
        this.currentUser = currentUser;
        this.songService = songService;
        this.userService = userService;
        this.homeService = homeService;
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
        model.addAttribute("songs", songService.findAllByStile());
        model.addAttribute("playlist", userService.findPlaylist());
        model.addAttribute("totalDurationOfPlaylist", userService.findPlaylistDuration());

        return "home";
    }

    @GetMapping("/addToPlaylist/{id}")
    public String addToPlaylist(@PathVariable Long id){
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        homeService.addToUserSongById(id, this.currentUser.getUsername());
        return "redirect:/home";
    }

    @GetMapping("/removeAll")
    public String removeAllSongs(){
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        homeService.removeAllSongsFromPlaylist(this.currentUser.getUsername());
        return "redirect:/home";
    }
}
