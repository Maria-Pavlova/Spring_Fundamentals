package com.example.musicdb.services;

import com.example.musicdb.models.dtos.bindingModels.AddAlbumModel;
import com.example.musicdb.models.dtos.viewModels.AlbumViewModel;
import com.example.musicdb.models.entities.Album;
import com.example.musicdb.repositories.AlbumRepository;
import com.example.musicdb.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public AlbumService(AlbumRepository albumRepository, ModelMapper modelMapper, ArtistService artistService, UserService userService, CurrentUser currentUser) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    public void addAlbum(AddAlbumModel addAlbumModel) {
        Album album = modelMapper.map(addAlbumModel, Album.class);
        album.setArtist(artistService.findByName(addAlbumModel.getArtist()));
        album.setAddedFrom(userService.findByUsername(currentUser.getUsername()).get());
        albumRepository.save(album);
    }

    public List<AlbumViewModel> findAll() {
        return albumRepository.findAll()
                .stream()
                .map(album -> modelMapper.map(album, AlbumViewModel.class))
                .toList();
    }

    public Integer getTotalCopies() {
        return findAll()
                .stream()
                .map(AlbumViewModel::getCopies)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }

}

