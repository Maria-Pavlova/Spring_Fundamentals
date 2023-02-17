package com.example.andreys.models.dtos.bindingModels;

import com.example.andreys.models.enums.CategoryName;
import com.example.andreys.models.enums.Gender;
import com.example.andreys.utils.validation.UniqueProductName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AddItemModel implements Serializable {
    @NotNull
    @Size(min = 2)
    @UniqueProductName
    private String name;
    @NotNull
    @Size(min = 3)
    private String description;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    private Gender gender;
    @NotNull
    private CategoryName category;
}
