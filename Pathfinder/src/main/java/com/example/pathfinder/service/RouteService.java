package com.example.pathfinder.service;

import com.example.pathfinder.models.dto.view.MostCommentedRouteView;
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

    //public List<Route> getMostCommented(){
     //   return routeRepository.findByCommentsSize().get(0);
    //}


    public MostCommentedRouteView getMostCommented(){
        Route route = this.routeRepository.findByCommentsSize().get(0);
      return MostCommentedRouteView.fromRoute(route);
    }
}
