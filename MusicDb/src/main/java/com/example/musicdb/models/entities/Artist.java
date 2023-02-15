package com.example.musicdb.models.entities;

import com.example.musicdb.models.enums.Singer;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "artists")
public class Artist extends BaseEntity{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Singer name;
    @Column(name = "career_information",columnDefinition = "text")
    private String careerInformation;
}
