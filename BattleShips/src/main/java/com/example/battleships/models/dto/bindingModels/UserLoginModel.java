package com.example.battleships.models.dto.bindingModels;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserLoginModel implements Serializable {
    @NotNull
    @Size(min = 3, max = 10)
    private String username;
    @NotNull
    @Size(min = 3)
    private String password;


}
