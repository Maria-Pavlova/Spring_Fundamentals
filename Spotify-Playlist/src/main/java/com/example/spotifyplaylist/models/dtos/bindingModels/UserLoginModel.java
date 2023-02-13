package com.example.spotifyplaylist.models.dtos.bindingModels;

import com.example.spotifyplaylist.validation.UserExist;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@UserExist
public class UserLoginModel {

    @NotNull
    @Size(min = 3, max = 20)
    private String username;
    @NotNull
    @Size(min = 3, max = 20)
    private String password;
}
