package com.example.shoppinglist.services;

import com.example.shoppinglist.models.dtos.bindingModels.AddProductModel;
import com.example.shoppinglist.models.dtos.viewModels.AllProductsViewModel;
import com.example.shoppinglist.models.entities.Product;
import com.example.shoppinglist.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    public void addProduct(AddProductModel productModel) {
        Product product = modelMapper.map(productModel, Product.class);
        product.setCategory(categoryService.findByName(productModel.getCategory()));
        productRepository.saveAndFlush(product);
    }

    public List<AllProductsViewModel> findAll() {
       return productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product, AllProductsViewModel.class))
                .toList();
    }

    public void buyProduct(Long id) {
        productRepository.deleteById(id);
    }

    public BigDecimal getTotalPrice() {
        return productRepository.findAll().stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public void buyAllProducts() {
        productRepository.deleteAll();
    }
}
