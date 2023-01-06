package com.mobilele.models.dtos;

import com.mobilele.models.enums.Engine;
import com.mobilele.models.enums.Transmission;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddOfferModel {
    @NotNull
    private String model;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Engine engine;
    @NotNull
    private Transmission transmission;
    @NotEmpty
    private String imageUrl;
    @NotNull
    private int year;
    @NotNull
    private Integer mileage;
    @NotNull
    private String description;


}
