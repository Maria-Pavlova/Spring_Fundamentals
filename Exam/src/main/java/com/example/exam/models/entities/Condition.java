package com.example.exam.models.entities;

import com.example.exam.models.enums.ConditionName;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private ConditionName name;

    @Column(columnDefinition = "text", nullable = false)
    private String description;


}
