package com.example.pathfinder.repositories;

import com.example.pathfinder.models.entities.Category;
import com.example.pathfinder.models.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(CategoryName categoryName);
}
