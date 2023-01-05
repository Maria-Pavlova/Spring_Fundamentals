package com.example.pathfinder.models.entities;

import com.example.pathfinder.models.enums.RoleName;
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
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private RoleName role;
}
