package com.example.spotifyplaylist.validation;

import com.example.spotifyplaylist.models.dtos.bindingModels.UserLoginModel;
import com.example.spotifyplaylist.models.entities.User;
import com.example.spotifyplaylist.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserExistValidator implements ConstraintValidator<UserExist, UserLoginModel> {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserExistValidator(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void initialize(UserExist constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginModel userLoginModel, ConstraintValidatorContext context) {
        Optional<User> optionalUser = userService.findByUsername(userLoginModel.getUsername());
        if (optionalUser.isEmpty()){
            return false;
        }
        String  rawPassword = userLoginModel.getPassword();
        String  encodedPassword  = optionalUser.get().getPassword();

        return passwordEncoder.matches(rawPassword, encodedPassword);

    }
}
