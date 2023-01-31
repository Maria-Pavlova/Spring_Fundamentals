package com.example.pathfinder.models.dto.bindingModels;

import com.example.pathfinder.models.enums.CategoryName;
import com.example.pathfinder.models.enums.Level;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import java.util.Set;

@Data
@NoArgsConstructor
public class AddRouteModel {
    @NotNull
    @Size(min = 3, max = 20, message = "The name must be between 3 and 20 characters!")
    private String name;
    @NotNull
    @Size(min = 5)
    private String description;
    private MultipartFile gpxCoordinates;
    @NotNull
    private Level level;
    private String videoUrl;
    private Set<CategoryName> categories;
}
