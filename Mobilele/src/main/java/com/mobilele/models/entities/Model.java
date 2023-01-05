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
@AllArgsConstructor
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
    private LocalDateTime created;
    private LocalDateTime modified;
    @ManyToOne
    private Brand brand;


    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", created=" + created +
                ", modified=" + modified +
                ", brand=" + (brand != null ? brand.getName() : null) +
                '}';
    }
}
