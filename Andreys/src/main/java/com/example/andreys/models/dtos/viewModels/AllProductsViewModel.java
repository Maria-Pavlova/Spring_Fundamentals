package com.example.andreys.models.dtos.viewModels;

import com.example.andreys.models.entities.Category;
import com.example.andreys.models.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AllProductsViewModel {
    private long id;
    private Category category;
    private String name;
    private BigDecimal price;
    private Gender gender;
}
