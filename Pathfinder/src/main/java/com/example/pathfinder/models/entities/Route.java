package com.example.pathfinder.models.entities;

import com.example.pathfinder.models.enums.Level;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "routes")
public class Route extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Column(columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private Level level;

    @ManyToOne
    private User author;

    @Column(name = "video_url")
    private String videoUrl;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "route", targetEntity = Comment.class, cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    private Set<Picture> picture;
}
