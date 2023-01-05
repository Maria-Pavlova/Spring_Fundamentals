package com.mobilele.models.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private boolean isActive;

    @ManyToMany
    private Set<UserRole> roles = new HashSet<>();

    @Column(name = "image_url")
    private String imageUrl;

    private LocalDateTime created;

    private LocalDateTime modified;

    public User addRole(UserRole userRole){
        this.roles.add(userRole);
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", roles=" + roles +
                ", imageUrl='" + imageUrl + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
