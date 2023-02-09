package com.example.shoppinglist.services;

import com.example.shoppinglist.models.entities.Category;
import com.example.shoppinglist.models.enums.CategoryName;
import com.example.shoppinglist.repositories.CategoryRepository;
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
}

