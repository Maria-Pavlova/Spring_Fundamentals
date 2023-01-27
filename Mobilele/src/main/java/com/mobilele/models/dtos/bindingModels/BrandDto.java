package com.mobilele.models.dtos.bindingModels;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BrandDto {

    private String name;
    private List<ModelDto> models;


    public BrandDto addModel(ModelDto modelDto){
        if (this.models == null){
            models = new ArrayList<>();
        }
        this.models.add(modelDto);
        return this;
    }
}
