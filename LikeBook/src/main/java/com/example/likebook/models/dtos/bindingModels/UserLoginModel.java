package com.example.likebook.models.dtos.bindingModels;

import com.example.likebook.utils.validation.UserExist;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@UserExist
public class UserLoginModel {

    @NotNull
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters.")
    private String username;
    @NotNull
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters.")
    private String password;
}
