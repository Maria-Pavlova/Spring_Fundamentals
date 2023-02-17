package com.example.pathfinder.repositories;

import com.example.pathfinder.models.entities.Category;
import com.example.pathfinder.models.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query("SELECT r FROM Route r ORDER BY size(r.comments) DESC")
    public List<Route> findByCommentsSize();

    Optional<List<Route>> findAllByCategories(Category category);



}
