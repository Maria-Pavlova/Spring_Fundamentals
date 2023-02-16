package com.example.shoppinglist.models.dtos.viewModels;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductViewModel {
    private long id;
    private String name;
    private BigDecimal price;
}
