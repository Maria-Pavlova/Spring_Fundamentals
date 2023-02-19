package com.example.exam.models.dtos.bindingModels;

import com.example.exam.models.enums.ConditionName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AddOfferModel implements Serializable {
    @NotNull
    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 characters.")
    private String description;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    private ConditionName condition;
}
