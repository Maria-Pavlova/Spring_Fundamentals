package com.example.spotifyplaylist.services;

import com.example.spotifyplaylist.models.entities.Style;
import com.example.spotifyplaylist.models.enums.StyleName;
import com.example.spotifyplaylist.repositories.StyleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StyleService {
    private final StyleRepository categoryRepository;

    public StyleService(StyleRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    private void postConstruct() {
        if (categoryRepository.count() == 0) {
            categoryRepository.saveAllAndFlush(Arrays.stream(StyleName.values())
                    .map(categoryName -> Style.builder()
                            .name(categoryName)
                            .description("")
                            .build())
                    .toList());
        }
    }

    public Style findByName(StyleName category) {
        return categoryRepository.findByName(category);
    }
}

