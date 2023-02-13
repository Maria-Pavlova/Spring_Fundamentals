package com.example.spotifyplaylist.services;

import com.example.spotifyplaylist.models.entities.Style;
import com.example.spotifyplaylist.models.enums.StyleName;
import com.example.spotifyplaylist.repositories.StyleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StyleService {
    private final StyleRepository styleRepository;

    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @PostConstruct
    private void postConstruct() {
        if (styleRepository.count() == 0) {
            styleRepository.saveAllAndFlush(Arrays.stream(StyleName.values())
                    .map(categoryName -> Style.builder()
                            .name(categoryName)
                            .description("")
                            .build())
                    .toList());
        }
    }

    public Style findByName(StyleName styleName) {
        return styleRepository.findByName(styleName);
    }


}

