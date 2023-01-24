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
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Level level;




    @Column(nullable = false)
    private String fullName;

    private int age;








//    @OneToMany(mappedBy = "author", targetEntity = Comment.class)
//    private Set<Comment> comments;


    public User(String username, String fullName, int age, String email, String password) {
        this();
        this.username = username;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.password = password;
    }
}
