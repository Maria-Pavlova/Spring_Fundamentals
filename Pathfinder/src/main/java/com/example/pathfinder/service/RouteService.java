package com.example.pathfinder.service;

import com.example.pathfinder.models.dto.bindingModels.AddRouteModel;
import com.example.pathfinder.models.dto.view.RouteDetailsView;
import com.example.pathfinder.models.dto.view.RouteViewModel;
import com.example.pathfinder.models.entities.Category;
import com.example.pathfinder.models.entities.Route;
import com.example.pathfinder.models.enums.CategoryName;
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

    public List<RouteViewModel> findAllRoutes() {
        return routeRepository.findAll()
              .stream()
                .map(route -> {
                            RouteViewModel routeViewModel = modelMapper.map(route, RouteViewModel.class);
                            if (route.getPicture().isEmpty()){
                                routeViewModel.setPictureUrl("/images/pic4.jpg");
                            }else {
                            routeViewModel.setPictureUrl(route.getPicture().stream().findFirst().get().getUrl());
                            }
                            return routeViewModel;
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


    public List<RouteViewModel> findByCategory(String categoryName) {

        Category category = this.categoryService.findByName(CategoryName.valueOf(categoryName.toUpperCase()));

        return routeRepository.findAllByCategories(category).orElseThrow()
                .stream()
                .map(route -> {
                    RouteViewModel routeViewModel = modelMapper.map(route, RouteViewModel.class);
                    if (route.getPicture().isEmpty()){
                        routeViewModel.setPictureUrl("/images/pic4.jpg");
                    }else {
                        routeViewModel.setPictureUrl(route.getPicture().stream().findFirst().get().getUrl());
                    }
                    return routeViewModel;
                })
                .toList();


    }
}
