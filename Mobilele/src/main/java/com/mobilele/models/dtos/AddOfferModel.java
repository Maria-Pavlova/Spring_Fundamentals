package com.mobilele.models.dtos;

import com.mobilele.models.enums.Engine;
import com.mobilele.models.enums.Transmission;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

//@Getter
//@Setter
@NoArgsConstructor

public class AddOfferModel {
    private Long id;
    @NotNull
    @Positive
    private Long modelId;
    @NotNull
    @Positive
    private Integer price;
    @NotNull
    private Engine engine;
    @NotNull
    private Transmission transmission;
    @NotNull
    private String imageUrl;
    @NotNull
    @Min(1900)
    @Max(2050)
    private Integer year;
    @NotNull
    @Positive
    private Integer mileage;
    @NotNull
    private String description;

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
