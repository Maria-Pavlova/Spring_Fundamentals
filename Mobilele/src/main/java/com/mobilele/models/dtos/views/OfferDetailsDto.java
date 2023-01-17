package com.mobilele.models.dtos.views;

import com.mobilele.models.enums.Engine;
import com.mobilele.models.enums.Transmission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDetailsDto implements Serializable {
    private String id;
    private Engine engine;
    private Integer mileage;
    private Integer price;
    private Transmission transmission;
    private LocalDateTime created;
    private LocalDateTime modified;
    private String imageUrl;
    private String seller;
    private int year;
    private String model;
    private String brand;

    public String getOfferHighlight() {
        return this.brand + " " + this.model + " - " + this.year;
    }
}
