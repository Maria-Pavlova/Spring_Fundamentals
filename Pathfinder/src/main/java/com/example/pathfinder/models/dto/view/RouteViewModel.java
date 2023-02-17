package com.example.pathfinder.models.dto.view;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class RouteViewModel implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String pictureUrl;

}
