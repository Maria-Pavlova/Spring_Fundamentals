package com.mobilele.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brands")
public class Brand extends BaseEntity{
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Model> models;

    public Brand(String name) {
        this.name=name;
    }


    public static Brand create(String name, Set<Model> models) {
        Brand brand = new Brand(name);
        models.stream().forEach(model -> {
            model.setBrand(brand);
            brand.getModels().add(model);
        });
        return brand;
    }
    @Override
    public String toString() {
        return "Brand{" +
                "name='" + name + '\'' +
                ", models=" + models +
                '}';
    }

}
