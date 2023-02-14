package com.example.gira.models.dtos.bindingModels;

import com.example.gira.models.enums.ClassificationName;
import com.example.gira.validation.UniqueTaskName;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AddTaskModel implements Serializable {
    @NotNull
    @Size(min = 3, max = 20)
    @UniqueTaskName
    private String name;
    @NotNull
    @Size(min = 5)
    private String description;
    @NotNull
    @FutureOrPresent
    private LocalDate dueDate;
    @NotNull
    private ClassificationName classification;
}
