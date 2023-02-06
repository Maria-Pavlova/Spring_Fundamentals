package com.example.battleships.services;

import com.example.battleships.models.entities.Category;
import com.example.battleships.models.enums.CategoryName;
import com.example.battleships.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void initCategories(){
        if (categoryRepository.count() == 0){
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category();
                        category.setName(categoryName);
                        categoryRepository.save(category);
                    });
        }
    }
}
