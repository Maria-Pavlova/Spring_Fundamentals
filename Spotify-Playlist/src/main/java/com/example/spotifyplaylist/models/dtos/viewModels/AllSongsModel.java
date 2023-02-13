package com.example.spotifyplaylist.models.dtos.viewModels;

import com.example.spotifyplaylist.models.entities.Style;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class AllSongsModel {
    List<SongModel> popSongs;
    List<SongModel> rockSongs;
    List<SongModel> jazzSongs;

//    private Long id;
//    private String performer;
//    private String title;
//    private Integer duration;
//    private Style style;
}
