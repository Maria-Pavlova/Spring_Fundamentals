package com.example.andreys.models.entities;

import com.example.andreys.models.enums.CategoryName;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private CategoryName name;

    @Column(columnDefinition = "text")
    private String description;


}
