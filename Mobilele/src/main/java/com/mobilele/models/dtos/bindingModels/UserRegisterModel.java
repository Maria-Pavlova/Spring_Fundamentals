package com.mobilele.models.dtos.bindingModels;

import com.mobilele.utils.validation.FieldsMatch;
import com.mobilele.utils.validation.UniqueUserName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@FieldsMatch(first = "password", second = "confirmPassword", message = "Passwords do not match.")
public class UserRegisterModel {
    @NotBlank
    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;
    @NotBlank
    @NotNull
    @Size(min = 2, max = 20)
    private String lastName;
    @Email(message = "Invalid email.")
    @NotBlank(message = "Username is required.")
    @UniqueUserName(message = "Username should be unique")
    private String username;
    @NotBlank
    @NotNull
    @Size(min = 5)
    private String password;
    @NotBlank
    @NotNull
    @Size(min = 5)
    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
