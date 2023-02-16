package com.example.shoppinglist.repositories;

import com.example.shoppinglist.models.entities.Category;
import com.example.shoppinglist.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    Optional<List<Product>>findAllByCategory(Category category);
}
