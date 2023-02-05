package com.example.coffeeshop.models.dto.viewModels;

import com.example.coffeeshop.models.entity.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class OrderViewModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;

}
