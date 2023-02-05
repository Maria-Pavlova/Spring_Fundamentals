package com.example.coffeeshop.models.dto.bindingModels;

import com.example.coffeeshop.util.validation.UniqueUserEmail;
import com.example.coffeeshop.util.validation.UniqueUserName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserRegisterModel implements Serializable {
    @NotNull
    @Size(min = 5, max = 20)
    @UniqueUserName(message = "Username should be unique")
    private String username;
    private String firstName;
    @NotNull
    @Size(min = 5, max = 20)
    private String lastName;
    @Email
    @UniqueUserEmail(message = "Email should be unique")
    private String email;
    @NotNull
    @Size(min = 3)
    private String password;
    @NotNull
    @Size(min = 3)
    private String confirmPassword;
}
