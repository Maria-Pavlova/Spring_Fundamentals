package com.example.shoppinglist.models.dtos.bindingModels;

import com.example.shoppinglist.models.enums.CategoryName;
import com.example.shoppinglist.utils.validation.UniqueProductName;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AddProductModel implements Serializable {
    @NotNull
    @Size(min = 3, max = 20)
    @UniqueProductName
    private String name;
    @NotNull
    @Size(min = 5)
    private String description;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    @FutureOrPresent
    private LocalDateTime neededBefore;
    @NotNull
    private CategoryName category;
}
