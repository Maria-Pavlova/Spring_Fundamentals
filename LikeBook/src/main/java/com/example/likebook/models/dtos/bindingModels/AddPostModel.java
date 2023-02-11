package com.example.likebook.models.dtos.bindingModels;

import com.example.likebook.models.enums.MoodName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AddPostModel implements Serializable {
    @NotNull
    @Size(min = 2, max = 50)
    private String content;
    @NotNull
    private MoodName mood;
}
