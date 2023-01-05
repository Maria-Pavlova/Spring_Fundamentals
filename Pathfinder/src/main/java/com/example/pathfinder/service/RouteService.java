package com.example.pathfinder.service;

import com.example.pathfinder.models.entities.Route;
import com.example.pathfinder.repositories.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<Route> getMostCommented(){
        return routeRepository.findByCommentsSize();
    }
}
