package com.mobilele.services;

import com.mobilele.models.dtos.BrandDto;
import com.mobilele.models.dtos.ModelDto;
import com.mobilele.models.dtos.views.AllBrandsView;
import com.mobilele.models.entities.Brand;
import com.mobilele.models.entities.Model;
import com.mobilele.repositories.BrandRepository;
import com.mobilele.repositories.ModelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public BrandService(BrandRepository brandRepository, ModelRepository modelRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

//
//    public void dbInit(){
//        if (brandRepository.count() == 0){
//
//        }
 //   }

    public List<AllBrandsView> getBrands(){
        return brandRepository.findAll()
                .stream()
                .map(brand -> modelMapper.map(brand, AllBrandsView.class))
                .collect(Collectors.toList());
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
