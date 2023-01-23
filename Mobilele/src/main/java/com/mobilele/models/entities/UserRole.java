package com.mobilele.models.entities;

import com.mobilele.models.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rols")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role role;

    public UserRole setId(Long id) {
        this.id = id;
        return this;
    }

    public UserRole setRole(Role role) {
        this.role = role;
        return this;
    }
}
