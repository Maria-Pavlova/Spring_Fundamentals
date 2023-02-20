package com.example.exam.services;

import com.example.exam.models.entities.Condition;
import com.example.exam.models.enums.ConditionName;
import com.example.exam.repositories.ConditionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConditionService {
    private final ConditionRepository conditionRepository;

    public ConditionService(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }


    @PostConstruct
    private void postConstruct() {
     if (conditionRepository.count() == 0) {
        Arrays.stream(ConditionName.values())
                .forEach(conditionName -> {
                    Condition condition = new Condition();
                    condition.setName(conditionName);
                    switch (conditionName) {
                        case EXCELLENT -> condition.setDescription("In perfect condition");
                        case GOOD -> condition.setDescription("Some signs of wear and tear or minor defects");
                        case ACCEPTABLE -> condition.setDescription("The item is fairly worn but continues to function properly");
                    }
                    conditionRepository.save(condition);
                });
    }
}


    public Condition findByName(ConditionName category) {
        return conditionRepository.findByName(category);
    }
}

