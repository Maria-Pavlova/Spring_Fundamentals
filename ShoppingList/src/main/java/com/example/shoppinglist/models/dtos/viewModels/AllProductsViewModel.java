package com.example.shoppinglist.models.dtos.viewModels;

import com.example.shoppinglist.models.entities.Category;
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
}
