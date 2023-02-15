package com.example.musicdb.models.dtos.bindingModels;

import com.example.musicdb.models.entities.Artist;
import com.example.musicdb.models.enums.Genre;
import com.example.musicdb.models.enums.Singer;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AddAlbumModel implements Serializable {
    @NotNull
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    @Size(min = 5)
    private String imageUrl;
    @NotNull
    @Size(min = 5)
    private String description;
    @NotNull
    @Min(10)
    private Integer copies;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    @PastOrPresent
    private LocalDate releasedDate;

    private String producer;
    @NotNull
    private Singer artist;
    @NotNull
    private Genre genre;
}
