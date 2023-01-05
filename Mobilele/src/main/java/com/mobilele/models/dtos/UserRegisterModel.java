package com.mobilele.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterModel {
    @NotBlank
    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;
    @NotBlank
    @NotNull
    @Size(min = 2, max = 20)
    private String lastName;
    @Email
    @NotBlank
    @NotNull
    private String username;
    @NotBlank
    @NotNull
    @Size(min = 5)
    private String password;
    @NotBlank
    @NotNull
    @Size(min = 5)
    private String confirmPassword;



}
