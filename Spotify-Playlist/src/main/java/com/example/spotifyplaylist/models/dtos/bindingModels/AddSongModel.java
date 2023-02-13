package com.example.spotifyplaylist.models.dtos.bindingModels;

import com.example.spotifyplaylist.models.enums.StyleName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class AddSongModel implements Serializable {
    @NotNull
    @Size(min = 3, max = 20)
    private String performer;
    @NotNull
    @Size(min = 2, max = 20)
    private String title;
    @NotNull
    @Positive
    private Integer duration;
    @NotNull
    @PastOrPresent
    private LocalDate releaseDate;
    @NotNull
    private StyleName style;
}
