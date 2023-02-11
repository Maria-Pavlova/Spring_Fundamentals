package com.example.likebook.models.dtos.viewModels;

import com.example.likebook.models.entities.Mood;
import com.example.likebook.models.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class PostViewModel implements Serializable {
    private Long id;
    private String content;
    private Mood mood;
    private Integer likes;
    private User user;

}
