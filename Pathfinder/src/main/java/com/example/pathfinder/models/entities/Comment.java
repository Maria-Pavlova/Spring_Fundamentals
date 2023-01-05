package com.example.pathfinder.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "comments")
public class Comment extends BaseEntity{

    private boolean approved;

    private LocalDateTime created;

    @Lob
    private String textContent;

    @ManyToOne
    private User author;

    @ManyToOne
    private Route route;
}
