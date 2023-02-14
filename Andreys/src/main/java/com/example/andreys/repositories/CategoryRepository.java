package com.example.andreys.repositories;

import com.example.andreys.models.entities.Category;
import com.example.andreys.models.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(CategoryName category);
}
