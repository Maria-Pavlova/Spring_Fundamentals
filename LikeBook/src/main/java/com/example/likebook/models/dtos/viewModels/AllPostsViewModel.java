package com.example.likebook.models.dtos.viewModels;

import com.example.likebook.models.entities.Mood;
import com.example.likebook.models.entities.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class AllPostsViewModel implements Serializable {
    private Long id;
    private String content;
    private Mood mood;
    private User user;
    private Integer likes;

}
