package com.mobilele.models.dtos.views;

import com.mobilele.models.enums.Engine;
import com.mobilele.models.enums.Transmission;
import lombok.Data;

import java.io.Serializable;

@Data
public class OffersView implements Serializable {
    private Long id;
    private Engine engine;
    private String imageUrl;
    private Integer mileage;
    private Integer price;
    private Transmission transmission;
    private Integer year;
    private String model;
    private String brand;
    private String seller;

    public String getOfferHighlight() {
        return this.brand + " " + this.model + " - " + this.year;
    }
}
