package com.example.coffeeshop.models.dto.viewModels;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserViewModel {

    private String username;
    private Integer countOfOrders;
}
