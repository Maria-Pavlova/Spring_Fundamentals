package com.example.spotifyplaylist.models.entities;

import com.example.spotifyplaylist.models.enums.StyleName;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Style extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private StyleName name;

    @Column(columnDefinition = "text")
    private String description;


}
