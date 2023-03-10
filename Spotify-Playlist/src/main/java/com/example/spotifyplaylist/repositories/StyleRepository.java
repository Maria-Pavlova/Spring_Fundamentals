package com.example.spotifyplaylist.repositories;

import com.example.spotifyplaylist.models.entities.Style;
import com.example.spotifyplaylist.models.enums.StyleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {

    Style findByName(StyleName styleName);
}
