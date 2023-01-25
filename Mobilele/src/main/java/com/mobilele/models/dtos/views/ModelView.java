package com.mobilele.models.dtos.views;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModelView {
    private String name;
    private String category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;

}
