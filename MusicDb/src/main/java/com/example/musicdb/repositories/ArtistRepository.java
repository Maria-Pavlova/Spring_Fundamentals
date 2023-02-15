package com.example.musicdb.repositories;

import com.example.musicdb.models.entities.Artist;
import com.example.musicdb.models.enums.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findByName(Singer singer);
}
