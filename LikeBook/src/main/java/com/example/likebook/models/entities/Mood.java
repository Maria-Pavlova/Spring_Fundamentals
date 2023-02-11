package com.example.likebook.models.entities;

import com.example.likebook.models.enums.MoodName;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "moods")
public class Mood extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private MoodName name;

    @Column(columnDefinition = "text")
    private String description;


}
