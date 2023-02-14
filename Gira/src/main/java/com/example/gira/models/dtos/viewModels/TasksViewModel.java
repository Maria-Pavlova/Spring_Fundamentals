package com.example.gira.models.dtos.viewModels;

import com.example.gira.models.entities.Classification;
import com.example.gira.models.entities.User;
import com.example.gira.models.enums.Progress;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class TasksViewModel implements Serializable {
    private Long id;
    private String name;
    private Progress progress;
    private LocalDate dueDate;
    private User user;
    private Classification classification;
}
