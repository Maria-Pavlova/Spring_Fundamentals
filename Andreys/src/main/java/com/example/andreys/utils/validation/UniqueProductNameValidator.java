package com.example.andreys.utils.validation;

import com.example.andreys.repositories.ItemRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueProductNameValidator implements ConstraintValidator<UniqueProductName,String> {
   private final ItemRepository itemRepository;

    public UniqueProductNameValidator(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return itemRepository.findByName(value).isEmpty();
    }
}
