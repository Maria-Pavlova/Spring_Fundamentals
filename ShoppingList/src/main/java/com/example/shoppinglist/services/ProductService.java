package com.example.shoppinglist.services;

import com.example.shoppinglist.models.dtos.bindingModels.AddProductModel;
import com.example.shoppinglist.models.dtos.viewModels.AllProductsViewModel;
import com.example.shoppinglist.models.dtos.viewModels.ProductViewModel;
import com.example.shoppinglist.models.entities.Category;
import com.example.shoppinglist.models.entities.Product;
import com.example.shoppinglist.models.enums.CategoryName;
import com.example.shoppinglist.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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

//    public List<AllProductsViewModel> findAll() {
//       return productRepository.findAll()
//                .stream()
//                .map(product -> modelMapper.map(product, AllProductsViewModel.class))
//                .toList();
//    }

    public AllProductsViewModel findByCategory(){
        Category footCategory = categoryService.findByName(CategoryName.FOOD);
        Category drinkCategory = categoryService.findByName(CategoryName.DRINK);
        Category otherCategory = categoryService.findByName(CategoryName.OTHER);
        Category householdCategory = categoryService.findByName(CategoryName.HOUSEHOLD);

        List<Product> food = this.productRepository.findAllByCategory(footCategory).orElse(null);
        List<Product> drinks = this.productRepository.findAllByCategory(drinkCategory).orElse(null);
        List<Product> other = this.productRepository.findAllByCategory(otherCategory).orElse(null);
        List<Product> household = this.productRepository.findAllByCategory(householdCategory).orElse(null);

        AllProductsViewModel products = new AllProductsViewModel();

        products.setFoodProducts(Objects.requireNonNull(food).stream().map(product -> modelMapper.map(product,ProductViewModel.class)).toList());
        products.setDrinkProducts(Objects.requireNonNull(drinks).stream().map(product -> modelMapper.map(product,ProductViewModel.class)).toList());
        products.setOtherProducts(Objects.requireNonNull(other).stream().map(product -> modelMapper.map(product,ProductViewModel.class)).toList());
        products.setHouseholdProducts(Objects.requireNonNull(household).stream().map(product -> modelMapper.map(product,ProductViewModel.class)).toList());
        
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
}
