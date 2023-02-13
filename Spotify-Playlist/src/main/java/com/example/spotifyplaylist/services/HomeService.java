package com.example.spotifyplaylist.services;

import com.example.spotifyplaylist.models.entities.Song;
import org.springframework.stereotype.Service;


@Service
public class HomeService {
    private final UserService userService;
    private final SongService songService;

    public HomeService(UserService userService, SongService songService) {
        this.userService = userService;
        this.songService = songService;
    }


    public void addToUserSongById(Long id, String username) {
        Song song = songService.findById(id);
        userService.addSongToUser(username, song);


    }

    public void removeAllSongsFromPlaylist(String username) {
        userService.removeAllSongsFromPlaylist(username);
    }
}
