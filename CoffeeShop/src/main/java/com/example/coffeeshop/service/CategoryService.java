package com.example.coffeeshop.service;

import com.example.coffeeshop.models.entity.Category;
import com.example.coffeeshop.models.entity.CategoryName;
import com.example.coffeeshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category();
                        category.setName(categoryName);
                        switch (categoryName) {
                            case CAKE -> category.setNeededTime(10);
                            case DRINK -> category.setNeededTime(1);
                            case COFFEE -> category.setNeededTime(2);
                            case OTHER -> category.setNeededTime(5);
                        }
                        categoryRepository.save(category);
                    });
        }
    }
}
