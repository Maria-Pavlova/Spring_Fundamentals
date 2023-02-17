package com.example.shoppinglist.services;

import com.example.shoppinglist.models.dtos.bindingModels.AddProductModel;
import com.example.shoppinglist.models.dtos.viewModels.AllProductsViewModel;
import com.example.shoppinglist.models.dtos.viewModels.ProductViewModel;
import com.example.shoppinglist.models.entities.Category;
import com.example.shoppinglist.models.entities.Product;
import com.example.shoppinglist.models.enums.CategoryName;
import com.example.shoppinglist.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper,
                          CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    public void addProduct(AddProductModel productModel) {
        Product product = modelMapper.map(productModel, Product.class);
        product.setCategory(categoryService.findByName(productModel.getCategory()));
        productRepository.saveAndFlush(product);
    }


    public AllProductsViewModel findByCategory(){

        List<Product> food = this.productRepository
                .findAllByCategory(categoryService.findByName(CategoryName.FOOD))
                .orElse(null);

        List<Product> drinks = this.productRepository
                .findAllByCategory(categoryService.findByName(CategoryName.DRINK))
                .orElse(null);

        List<Product> other = this.productRepository
                .findAllByCategory(categoryService.findByName(CategoryName.OTHER))
                .orElse(null);

        List<Product> household = this.productRepository
                .findAllByCategory(categoryService.findByName(CategoryName.HOUSEHOLD)).
                orElse(null);

        AllProductsViewModel products = new AllProductsViewModel();

        products.setFoodProducts(Objects.requireNonNull(food)
                .stream()
                .map(product -> modelMapper.map(product,ProductViewModel.class))
                .toList());
        products.setDrinkProducts(Objects.requireNonNull(drinks)
                .stream()
                .map(product -> modelMapper.map(product,ProductViewModel.class))
                .toList());
        products.setOtherProducts(Objects.requireNonNull(other)
                .stream()
                .map(product -> modelMapper.map(product,ProductViewModel.class))
                .toList());
        products.setHouseholdProducts(Objects.requireNonNull(household)
                .stream()
                .map(product -> modelMapper.map(product,ProductViewModel.class))
                .toList());
        
        return products;
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

    //    public List<AllProductsViewModel> findAll() {
//       return productRepository.findAll()
//                .stream()
//                .map(product -> modelMapper.map(product, AllProductsViewModel.class))
//                .toList();
//    }
}
