package com.example.pathfinder.service;

import com.example.pathfinder.models.entities.Category;
import com.example.pathfinder.models.enums.CategoryName;
import com.example.pathfinder.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category findByName(CategoryName categoryName) {
      return categoryRepository.findByName(categoryName).orElseThrow();
    }
}
