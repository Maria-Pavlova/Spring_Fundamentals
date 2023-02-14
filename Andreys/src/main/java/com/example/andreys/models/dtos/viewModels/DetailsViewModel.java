package com.example.andreys.models.dtos.viewModels;

import com.example.andreys.models.entities.Category;
import com.example.andreys.models.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class DetailsViewModel {
    private long id;
    private Category category;
    private Gender gender;
    private String name;
    private String description;
    private BigDecimal price;
}
