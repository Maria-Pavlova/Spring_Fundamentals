package com.example.exam.models.dtos.viewModels;

import com.example.exam.models.entities.Condition;
import com.example.exam.models.entities.User;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OfferViewModel implements Serializable {
    private Long id;
    private String description;
    private BigDecimal price;
    private Condition condition;
    private User seller;
}
