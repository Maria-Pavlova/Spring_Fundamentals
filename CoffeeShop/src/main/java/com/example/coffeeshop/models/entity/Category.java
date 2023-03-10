package com.example.coffeeshop.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private CategoryName name;
    @Column(name = "needed_time", nullable = false)
    private Integer neededTime;

}
