package com.example.musicdb.services;

import com.example.musicdb.models.entities.Artist;
import com.example.musicdb.models.enums.Singer;
import com.example.musicdb.repositories.ArtistRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    @PostConstruct
    private void postConstruct() {
        if (artistRepository.count() == 0) {
            artistRepository.saveAllAndFlush(Arrays.stream(Singer.values())
                    .map(singer -> Artist.builder()
                            .name(singer)
                            .careerInformation("")
                            .build())
                    .toList());
        }
    }

    public Artist findByName(Singer singer) {
        return artistRepository.findByName(singer);
    }
}

