package com.example.pathfinder.models.dto.view;

import com.example.pathfinder.models.entities.Picture;
import com.example.pathfinder.models.enums.Level;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class RouteDetailsView implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String gpxCoordinates;
    private Level level;
    private String videoUrl;
    private List<Picture> picture;
    private String authorName;
}
