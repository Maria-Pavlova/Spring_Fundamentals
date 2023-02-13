package com.example.spotifyplaylist.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "songs")
public class Song extends BaseEntity{

    @Column(nullable = false)
    private String performer;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Integer duration;
    @Column(name = "release_date",nullable = true)
    private LocalDate releaseDate;
    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private Style style;

}
