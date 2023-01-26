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
 //   private Long id;
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

//    public Long getId() {
//        return id;
//    }

//    public AddOfferModel setId(Long id) {
//        this.id = id;
//        return this;
//    }

    public Long getModelId() {
        return modelId;
    }

    public AddOfferModel setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public AddOfferModel setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public AddOfferModel setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public AddOfferModel setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddOfferModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public AddOfferModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public AddOfferModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddOfferModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "AddOfferModel{" +
                "modelId=" + modelId +
                ", price=" + price +
                ", engine=" + engine +
                ", transmission=" + transmission +
                ", imageUrl='" + imageUrl + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", description='" + description + '\'' +
                '}';
    }
}
