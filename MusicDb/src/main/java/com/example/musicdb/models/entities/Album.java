package com.example.musicdb.models.entities;

import com.example.musicdb.models.enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "albums")
public class Album extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String imageUrl;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer copies;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(name = "released_date")
    private LocalDate releasedDate;
    @Column(nullable = false)
    private String producer;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private Artist artist;
    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private User addedFrom;
}
