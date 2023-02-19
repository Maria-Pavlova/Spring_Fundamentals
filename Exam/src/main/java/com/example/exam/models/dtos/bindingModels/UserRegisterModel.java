package com.example.exam.models.dtos.bindingModels;

import com.example.exam.utils.validation.FieldsMatch;
import com.example.exam.utils.validation.UniqueUserName;
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
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters.")
    @UniqueUserName(message = "Username is occupied")
    private String username;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 3, max = 20)
    private String password;
    @NotNull
    private String confirmPassword;

}
