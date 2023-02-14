package com.example.andreys.services;

import com.example.andreys.models.entities.Category;
import com.example.andreys.models.enums.CategoryName;
import com.example.andreys.repositories.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    private void postConstruct() {
        if (categoryRepository.count() == 0) {
            categoryRepository.saveAllAndFlush(Arrays.stream(CategoryName.values())
                    .map(categoryName -> Category.builder()
                            .name(categoryName)
                            .description("")
                            .build())
                    .toList());
        }
    }

    public Category findByName(CategoryName category) {
        return categoryRepository.findByName(category);
    }
}

