package com.mobilele.models.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;


    @Column(nullable = false)
    private boolean isActive;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private Set<UserRole> roles;


    @Column(name = "image_url")
    private String imageUrl;

    public User() {
        this.roles = new HashSet<>();
    }

    public User(String firstName, String lastName, String username,
                String password, boolean isActive, Set<UserRole> roles, String imageUrl) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.roles = roles;
        this.imageUrl = imageUrl;
    }

    public User addRole(UserRole userRole){
        this.roles.add(userRole);
        return this;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setActive(boolean active) {
        isActive = active;
        return this;
    }

    public User setRoles(Set<UserRole> roles) {
        this.roles = roles;
        return this;
    }

    public User setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
                '}';
    }
}
