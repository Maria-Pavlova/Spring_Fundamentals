package com.example.pathfinder.models.entities;

import com.example.pathfinder.models.enums.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String username;

    private String fullName;

    private int age;

    @Transient
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Level level;

//    @OneToMany(mappedBy = "author", targetEntity = Comment.class)
//    private Set<Comment> comments;
}
