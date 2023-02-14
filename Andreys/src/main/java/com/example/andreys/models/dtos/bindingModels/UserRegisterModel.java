package com.example.andreys.models.dtos.bindingModels;

import com.example.andreys.utils.validation.FieldsMatch;
import com.example.andreys.utils.validation.UniqueUserName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@FieldsMatch(first = "password", second = "confirmPassword", message = "Passwords do not match.")
public class UserRegisterModel implements Serializable {
    @NotNull
    @Size(min = 2)
    @UniqueUserName(message = "Username is occupied")
    private String username;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 2)
    private String password;
    @NotNull
    @Size(min = 2)
    private String confirmPassword;
    @NotNull
    @Positive
    private BigDecimal budget;
}
