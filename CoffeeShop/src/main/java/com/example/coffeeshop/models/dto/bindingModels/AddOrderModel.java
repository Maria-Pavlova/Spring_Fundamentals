package com.example.coffeeshop.models.dto.bindingModels;

import com.example.coffeeshop.models.entity.CategoryName;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AddOrderModel implements Serializable {
    @NotNull
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    @DecimalMin("1")
    private BigDecimal price;
    @NotNull
    @DateTimeFormat(pattern = "mm/dd/yyyy --:-- --")
    @PastOrPresent(message = "Order time can not be in the future")
    private LocalDateTime orderTime;
    @NotNull
    private CategoryName category;
    @NotNull
    @Size(min = 5)
    private String description;
}
