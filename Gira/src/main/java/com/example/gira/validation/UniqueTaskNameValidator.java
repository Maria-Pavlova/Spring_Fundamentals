package com.example.gira.validation;

import com.example.gira.repositories.TaskRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueTaskNameValidator implements ConstraintValidator<UniqueTaskName,String> {
   private final TaskRepository taskRepository;

    public UniqueTaskNameValidator(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return taskRepository.findByName(value).isEmpty();
    }
}
