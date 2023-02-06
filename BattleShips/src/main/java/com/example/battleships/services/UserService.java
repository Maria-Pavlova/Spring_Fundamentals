package com.example.battleships.services;

import com.example.battleships.models.dto.bindingModels.UserLoginModel;
import com.example.battleships.models.dto.bindingModels.UserRegisterModel;
import com.example.battleships.models.entities.User;
import com.example.battleships.repositories.UserRepository;
import com.example.battleships.security.CurrentUser;
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

        if (userModel.getPassword().equals(userModel.getConfirmPassword())){
            User user = modelMapper.map(userModel, User.class);
            user.setPassword(passwordEncoder.encode(userModel.getPassword()));
            userRepository.save(user);
        }
    }

    public boolean isAuthenticateAndLogin(UserLoginModel userLoginModel){
        Optional<User> optionalUser = userRepository.findByUsername(userLoginModel.getUsername());

        if (optionalUser.isEmpty()){
            LOGGER.info("User with name [{}] not found.", userLoginModel.getUsername());
            return false;
        }
        String  rawPassword = userLoginModel.getPassword();
        String  encodedPassword  = optionalUser.get().getPassword();

        if (passwordEncoder.matches(rawPassword, encodedPassword)) {
            login(optionalUser.get());
            LOGGER.info("User with name [{}] logged in.", userLoginModel.getUsername());
            return true;
        }
        return false;
    }

    public void logout(){
        currentUser.clear();
    }

    private void login(User user) {
        currentUser.setUsername(user.getUsername());
        currentUser.setLoggedIn(true);

    }
}
