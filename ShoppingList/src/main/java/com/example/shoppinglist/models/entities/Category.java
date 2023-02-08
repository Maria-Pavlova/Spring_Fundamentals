package com.example.shoppinglist.models.entities;

import com.example.shoppinglist.models.enums.CategoryName;
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
    @Column(unique = true)
    private CategoryName name;

    @Column(columnDefinition = "text")
    private String description;
}
