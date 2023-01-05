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

    private LocalDateTime created;

    private LocalDateTime modified;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Model> models;

    @Override
    public String toString() {
        return "Brand{" +
                "name='" + name + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", models=" + models +
                '}';
    }
}
