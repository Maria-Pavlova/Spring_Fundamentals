package com.example.gira.models.dtos.bindingModels;

import com.example.gira.validation.FieldsMatch;
import com.example.gira.validation.UniqueUserEmail;
import com.example.gira.validation.UniqueUserName;
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
    @Size(min = 3, max = 20)
    @UniqueUserName(message = "Username is occupied")
    private String username;
    @NotNull
    @Email
    @UniqueUserEmail(message = "Email is occupied")
    private String email;
    @NotNull
    @Size(min = 3, max = 20)
    private String password;
    @NotNull
    @Size(min = 3, max = 20)
    private String confirmPassword;

}
