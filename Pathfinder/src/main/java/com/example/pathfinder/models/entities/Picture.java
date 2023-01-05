package com.example.pathfinder.models.entities;

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
@Table(name = "pictures")
public class Picture extends BaseEntity {
    @Column
    private String title;
    @Column(columnDefinition = "text", nullable = false)
    private String url;
    @ManyToOne
    private User author;
    @ManyToOne
    private Route route;
}
