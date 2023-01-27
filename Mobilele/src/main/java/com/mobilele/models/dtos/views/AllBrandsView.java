package com.mobilele.models.dtos.views;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class AllBrandsView implements Serializable {

    private String name;
    private List<ModelView> models;


}
