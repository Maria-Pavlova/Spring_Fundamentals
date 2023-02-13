package com.example.spotifyplaylist.services;

import com.example.spotifyplaylist.models.dtos.bindingModels.AddSongModel;
import com.example.spotifyplaylist.models.entities.Song;
import com.example.spotifyplaylist.repositories.SongRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    private final SongRepository songRepository;
    private final ModelMapper modelMapper;
    private final StyleService styleService;

    public SongService(SongRepository songRepository, ModelMapper modelMapper, StyleService styleService) {
        this.songRepository = songRepository;
        this.modelMapper = modelMapper;
        this.styleService = styleService;
    }

    public void addSong(AddSongModel addSongModel) {

        Song song = modelMapper.map(addSongModel, Song.class);
        song.setStyle(styleService.findByName(addSongModel.getStyle()));

        songRepository.saveAndFlush(song);
    }
}
