package com.example.exam.models.dtos.viewModels;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BoughtItemsView {
    private String description;
    private BigDecimal price;
}
