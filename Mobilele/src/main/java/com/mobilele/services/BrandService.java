package com.mobilele.services;

import com.mobilele.models.dtos.BrandDto;
import com.mobilele.models.dtos.ModelDto;
import com.mobilele.models.entities.Brand;
import com.mobilele.models.entities.Model;
import com.mobilele.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDto> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(this::mapBrand)
                .collect(Collectors.toList());
    }

    private BrandDto mapBrand(Brand brand) {
        List<ModelDto> models =
                brand.getModels()
                        .stream()
                        .map(this::mapModel)
                        .toList();
        BrandDto brandDto = new BrandDto();
        brandDto.setModels(models);
        brandDto.setName(brand.getName());
        return brandDto;
    }

    private ModelDto mapModel(Model model){
        ModelDto modelDto = new ModelDto();
                modelDto.setId(model.getId());
                modelDto.setName(model.getName());
                return modelDto;
    }
}
