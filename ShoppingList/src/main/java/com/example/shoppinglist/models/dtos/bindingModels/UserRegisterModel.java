package com.example.shoppinglist.models.dtos.bindingModels;

import com.example.shoppinglist.utils.validation.FieldsMatch;
import com.example.shoppinglist.utils.validation.UniqueUserEmail;
import com.example.shoppinglist.utils.validation.UniqueUserName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@FieldsMatch(first = "password", second = "confirmPassword", message = "Passwords do not match.")
public class UserRegisterModel implements Serializable {
    @NotNull
    @Size(min = 3, max = 10)
    @UniqueUserName(message = "Username is occupied")
    private String username;
    @NotNull
    @Email
    @UniqueUserEmail(message = "Email must be unique")
    private String email;
    @NotNull
    @Size(min = 3)
    private String password;
    @NotNull
    @Size(min = 3)
    private String confirmPassword;
//todo validation
}
