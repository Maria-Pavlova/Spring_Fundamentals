package com.example.shoppinglist.models.dtos.viewModels;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AllProductsViewModel {

   List<ProductViewModel> foodProducts;
   List<ProductViewModel> drinkProducts;
   List<ProductViewModel> householdProducts;
   List<ProductViewModel> otherProducts;
}
