package com.example.pathfinder.models.dto.view;

import com.example.pathfinder.models.entities.Route;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.NoSuchElementException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MostCommentedRouteView {
    private String name;
    private String description;
    private String imageUrl;

    public static MostCommentedRouteView fromRoute(Route route){
        return new MostCommentedRouteView(route.getName(), route.getDescription(),
                route.getPicture()
                        .stream()
                        .findFirst()
                        .orElseThrow(NoSuchElementException::new)
                        .getUrl());
    }
}
