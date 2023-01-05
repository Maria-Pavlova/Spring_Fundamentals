package com.example.pathfinder.models.entities;

import com.example.pathfinder.models.enums.CategoryName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CategoryName name;

    @Column(columnDefinition = "TEXT")
    private String description;




}
