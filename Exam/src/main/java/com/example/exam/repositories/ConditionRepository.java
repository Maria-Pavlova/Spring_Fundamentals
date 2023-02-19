package com.example.exam.repositories;

import com.example.exam.models.entities.Condition;
import com.example.exam.models.enums.ConditionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {

    Condition findByName(ConditionName category);
}
