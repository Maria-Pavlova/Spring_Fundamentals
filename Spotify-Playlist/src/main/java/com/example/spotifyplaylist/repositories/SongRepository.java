package com.example.spotifyplaylist.repositories;

import com.example.spotifyplaylist.models.entities.Song;
import com.example.spotifyplaylist.models.entities.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findByStyle(Style style);
}
