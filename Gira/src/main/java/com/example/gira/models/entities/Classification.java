package com.example.gira.models.entities;

import com.example.gira.models.enums.ClassificationName;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private ClassificationName name;

    @Column(columnDefinition = "text")
    private String description;


}
