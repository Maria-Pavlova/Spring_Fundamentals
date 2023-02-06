package com.example.battleships.models.dto.bindingModels;

import com.example.battleships.utils.validation.UniqueUserEmail;
import com.example.battleships.utils.validation.UniqueUserName;
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
    @Size(min = 3, max = 10)
    @UniqueUserName(message = "Username is occupied")
    private String username;
    @NotNull
    @Size(min = 5, max = 20)
    private String fullName;
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

}
