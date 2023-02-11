package com.example.likebook.services;

import com.example.likebook.models.entities.Mood;
import com.example.likebook.models.enums.MoodName;
import com.example.likebook.repositories.MoodRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MoodService {
    private final MoodRepository moodRepository;

    public MoodService(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }


    @PostConstruct
    private void postConstruct() {
        if (moodRepository.count() == 0) {
            moodRepository.saveAllAndFlush(Arrays.stream(MoodName.values())
                    .map(moodName -> Mood.builder()
                            .name(moodName)
                            .description("")
                            .build())
                    .toList());
        }
    }

    public Mood findByName(MoodName name) {
        return moodRepository.findByName(name);
    }
}

