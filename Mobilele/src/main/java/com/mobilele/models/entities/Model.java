package com.mobilele.models.entities;

import com.mobilele.models.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "models")
public class Model extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "image_url", length = 512)
    private String imageUrl;
    @Column(name = "start_year")
    private Integer startYear;
    @Column(name = "end_year")
    private Integer endYear;
    @ManyToOne
    private Brand brand;

    public Model(String name, Category category, String imageUrl, Integer startYear, Integer endYear, Brand brand) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
    }




    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", brand=" + (brand != null ? brand.getName() : null) +
                '}';
    }
}
