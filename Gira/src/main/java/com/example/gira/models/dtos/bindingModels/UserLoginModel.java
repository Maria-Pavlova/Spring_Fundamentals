package com.example.gira.models.dtos.bindingModels;

import com.example.gira.validation.UserExist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@UserExist
public class UserLoginModel {

    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 3, max = 20)
    private String password;
}
