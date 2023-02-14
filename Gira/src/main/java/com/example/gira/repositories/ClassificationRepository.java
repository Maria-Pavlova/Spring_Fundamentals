package com.example.gira.repositories;

import com.example.gira.models.entities.Classification;
import com.example.gira.models.enums.ClassificationName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {
    Classification findByName(ClassificationName category);
}
