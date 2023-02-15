package com.example.musicdb.models.dtos.viewModels;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AllProductsViewModel {
    private long id;
 //   private Category category;
    private String name;
    private BigDecimal price;
}
