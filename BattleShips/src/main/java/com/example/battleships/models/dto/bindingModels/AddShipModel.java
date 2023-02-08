package com.example.battleships.models.dto.bindingModels;

import com.example.battleships.models.enums.CategoryName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.time.LocalDate;


@Data
public class AddShipModel implements Serializable {
    @NotNull
    @Size(min = 2, max = 10)
    private String name;
    @NotNull
    @Positive
    private Long health;
    @NotNull
    @Positive
    private Long power;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd" + " г.")
    @PastOrPresent(message = "Date can`t be in the future.")
    private LocalDate created;
    @NotNull
    private CategoryName category;
}
