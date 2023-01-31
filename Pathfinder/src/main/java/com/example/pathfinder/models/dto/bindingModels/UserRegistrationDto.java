package com.example.pathfinder.models.dto.bindingModels;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserRegistrationDto implements Serializable {

    @NotBlank
    @Size(min = 5, max = 20)
    private String username;
    @NotBlank
    @Size(min = 5, max = 20)
    private String fullname;
    @NotBlank
    @Email
    private String email;
    @Min(0)
    @Max(90)
    private int age;
    @NotBlank
    @Size(min = 5, max = 20)
    private String password;
    @NotBlank
    @Size(min = 5, max = 20)
    private String confirmPassword;

}
