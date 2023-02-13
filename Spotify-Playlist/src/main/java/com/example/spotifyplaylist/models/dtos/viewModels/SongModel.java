package com.example.spotifyplaylist.models.dtos.viewModels;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SongModel {
    private Long id;
    private String performer;
    private String title;
    private Integer duration;

    public void setDuration(Integer duration) {
        this.duration = duration / 60;
    }

}
