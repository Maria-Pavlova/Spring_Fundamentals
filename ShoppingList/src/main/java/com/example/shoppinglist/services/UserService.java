package com.example.shoppinglist.services;

import com.example.shoppinglist.models.dtos.bindingModels.UserLoginModel;
import com.example.shoppinglist.models.dtos.bindingModels.UserRegisterModel;
import com.example.shoppinglist.models.entities.User;
import com.example.shoppinglist.repositories.UserRepository;
import com.example.shoppinglist.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, ModelMapper modelMapper,
                       PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }


    public void registerUser(UserRegisterModel userModel) {

        User user = modelMapper.map(userModel, User.class);
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(user);
        LOGGER.info("User with name [{}] registered.", userModel.getUsername());

    }

    public void login(UserLoginModel userLoginModel) {
        User user = findByUsername(userLoginModel.getUsername()).get();
        currentUser.setUsername(user.getUsername());
        currentUser.setLoggedIn(true);
        LOGGER.info("User with name [{}] logged in.", userLoginModel.getUsername());
    }

    public void logout() {
        LOGGER.info("User with name [{}] logged out.", currentUser.getUsername());
        currentUser.clear();
    }


    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
