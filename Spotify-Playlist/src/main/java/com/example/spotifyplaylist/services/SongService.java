package com.example.spotifyplaylist.services;

import com.example.spotifyplaylist.models.dtos.bindingModels.AddSongModel;
import com.example.spotifyplaylist.models.dtos.viewModels.AllSongsModel;
import com.example.spotifyplaylist.models.dtos.viewModels.SongModel;
import com.example.spotifyplaylist.models.entities.Song;
import com.example.spotifyplaylist.models.entities.Style;
import com.example.spotifyplaylist.models.enums.StyleName;
import com.example.spotifyplaylist.repositories.SongRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SongService {
    private final SongRepository songRepository;
    private final ModelMapper modelMapper;
    private final StyleService styleService;


    public SongService(SongRepository songRepository, ModelMapper modelMapper,
                       StyleService styleService) {
        this.songRepository = songRepository;
        this.modelMapper = modelMapper;
        this.styleService = styleService;

    }

    public void addSong(AddSongModel addSongModel) {
        Song song = modelMapper.map(addSongModel, Song.class);
        song.setStyle(styleService.findByName(addSongModel.getStyle()));
        songRepository.saveAndFlush(song);
    }

    public List<AllSongsModel> findAll() {
        return songRepository.findAll()
                .stream()
                .map(song -> modelMapper.map(song, AllSongsModel.class))
                .toList();
    }


    public Song findById(Long id) {
        return songRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }



    public AllSongsModel findAllByStile() {

        AllSongsModel songs = new AllSongsModel();

        Style popStyle = styleService.findByName(StyleName.POP);
        Style rockStyle = styleService.findByName(StyleName.ROCK);
        Style jazzStyle = styleService.findByName(StyleName.JAZZ);

        songs.setPopSongs(songRepository.findByStyle(popStyle)
                .stream()
                .map(song -> modelMapper.map(song, SongModel.class))
                .toList());
        songs.setRockSongs(songRepository.findByStyle(rockStyle)
                .stream()
                .map(song -> modelMapper.map(song, SongModel.class)).toList());
        songs.setJazzSongs(songRepository.findByStyle(jazzStyle)
                .stream()
                .map(song -> modelMapper.map(song, SongModel.class)).toList());

        return songs;
    }
}
