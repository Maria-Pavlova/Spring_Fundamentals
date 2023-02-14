package com.example.andreys.services;

import com.example.andreys.models.dtos.bindingModels.AddItemModel;
import com.example.andreys.models.dtos.viewModels.AllProductsViewModel;
import com.example.andreys.models.dtos.viewModels.DetailsViewModel;
import com.example.andreys.models.entities.Item;
import com.example.andreys.repositories.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ItemService(ItemRepository itemRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    public void addItem(AddItemModel itemModel) {
        Item item = modelMapper.map(itemModel, Item.class);
        item.setCategory(categoryService.findByName(itemModel.getCategory()));
        itemRepository.saveAndFlush(item);
    }

    public List<AllProductsViewModel> findAll() {
       return itemRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product, AllProductsViewModel.class))
                .toList();
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }



    public DetailsViewModel getDetails(Long id) {
        return modelMapper.map(itemRepository.findById(id).get(), DetailsViewModel.class);
    }
}
