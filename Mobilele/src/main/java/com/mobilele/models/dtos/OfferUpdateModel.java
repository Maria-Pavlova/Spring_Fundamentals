package com.mobilele.models.dtos;

import com.mobilele.models.enums.Engine;
import com.mobilele.models.enums.Transmission;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferUpdateModel implements Serializable {

    private String id;
    @NotNull
    private String description;
    @NotNull
    private Engine engine;
    @NotNull
    private String imageUrl;
    @NotNull
    @PositiveOrZero
    private Integer mileage;
    @NotNull
    @Min(100)
    private Integer price;
    @NotNull
    private Transmission transmission;
    @NotNull
    @Min(1900)
    private Integer year;
}
