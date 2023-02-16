package com.example.likebook.models.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post extends BaseEntity {
    @Column(nullable = false)
    private String content;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @Column
    private Integer likes = 0;
    @ManyToOne(fetch = FetchType.EAGER)
    private Mood mood;

    //    @ManyToMany
//    @Fetch(FetchMode.JOIN)
//    private Set<User> userLikes;

    }


