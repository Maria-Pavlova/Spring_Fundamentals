package com.example.shoppinglist.models.dtos.bindingModels;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserLoginModel {

    @NotNull
    @Size(min = 3, max = 10)
    private String username;
    @NotNull
    @Size(min = 3, max = 10) //TODO
    private String password;
}
