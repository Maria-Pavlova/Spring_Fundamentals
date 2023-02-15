package com.example.musicdb.models.dtos.viewModels;

import com.example.musicdb.models.entities.Artist;
import com.example.musicdb.models.enums.Genre;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AlbumViewModel implements Serializable {
    private Long id;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private LocalDate releasedDate;
    private Genre genre;
    private Artist artist;
    private Integer copies;
}
