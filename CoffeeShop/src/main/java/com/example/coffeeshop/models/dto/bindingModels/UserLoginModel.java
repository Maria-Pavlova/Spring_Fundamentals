package com.example.coffeeshop.models.dto.bindingModels;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserLoginModel {
    @NotNull
    @Size(min = 5, max = 20)
    private String username;
    @NotNull
    @Size(min = 3)
    private String password;
}
