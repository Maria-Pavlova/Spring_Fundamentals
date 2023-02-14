package com.example.gira.services;

import com.example.gira.models.entities.Classification;
import com.example.gira.models.enums.ClassificationName;
import com.example.gira.repositories.ClassificationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationService {
    private final ClassificationRepository classificationRepository;

    public ClassificationService(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @PostConstruct
    private void postConstruct() {
        if (classificationRepository.count() == 0) {
            classificationRepository.saveAllAndFlush(Arrays.stream(ClassificationName.values())
                    .map(categoryName -> Classification.builder()
                            .name(categoryName)
                            .description("")
                            .build())
                    .toList());
        }
    }

    public Classification findByName(ClassificationName classificationName) {
        return classificationRepository.findByName(classificationName);
    }
}

