package com.example.pathfinder.service;

import com.example.pathfinder.models.dto.bindingModels.AddRouteModel;
import com.example.pathfinder.models.dto.view.RouteDetailsView;
import com.example.pathfinder.models.dto.view.RouteModel;
import com.example.pathfinder.models.entities.Route;
import com.example.pathfinder.repositories.RouteRepository;
import com.example.pathfinder.repositories.UserRepository;
import com.example.pathfinder.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final CategoryService categoryService;

    @Autowired
    public RouteService(RouteRepository routeRepository, ModelMapper modelMapper,
                        UserRepository userRepository, CurrentUser currentUser,
                        CategoryService categoryService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.categoryService = categoryService;
    }

    public List<Route> getMostCommented() {
        return routeRepository.findByCommentsSize();
    }

    public List<RouteModel> findAllRoutes() {
        return routeRepository.findAll()
              .stream().map(route -> {
                            RouteModel routeModel = modelMapper.map(route, RouteModel.class);
                            if (route.getPicture().isEmpty()){
                                routeModel.setPictureUrl("/images/pic4.jpg");
                            }else {
                            routeModel.setPictureUrl(route.getPicture().stream().findFirst().get().getUrl());
                            }
                            return routeModel;
                        })
                .collect(Collectors.toList());

    }

    public RouteDetailsView getDetails(Long id) {
      return routeRepository.findById(id)
                .map(route ->{
                    RouteDetailsView detailsView = modelMapper.map(route, RouteDetailsView.class);
                    detailsView.setAuthorName(route.getAuthor().getUsername());
                    return detailsView;
                })
              .orElse(null);

    }

    public void addRoute(AddRouteModel addRouteModel) throws IOException {
        Route route = modelMapper.map(addRouteModel, Route.class);

        route.setAuthor(userRepository.findByUsername(currentUser.getUsername()).orElseThrow());

        route.setCategories(addRouteModel
                .getCategories()
                .stream()
                .map(categoryService::findByName)
                .collect(Collectors.toSet()));

        route.setGpxCoordinates(new String(addRouteModel.getGpxCoordinates().getBytes()));

        routeRepository.save(route);
    }

//
//    public MostCommentedRouteView getMostCommented(){
//        Route route = this.routeRepository.findByCommentsSize().get(0);
//      return MostCommentedRouteView.fromRoute(route);
//    }
}
