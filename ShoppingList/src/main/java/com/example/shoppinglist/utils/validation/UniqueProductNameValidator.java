package com.example.shoppinglist.utils.validation;

import com.example.shoppinglist.repositories.ProductRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueProductNameValidator implements ConstraintValidator<UniqueProductName,String> {
   private final ProductRepository productRepository;

    public UniqueProductNameValidator(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return productRepository.findByName(value).isEmpty();
    }
}
