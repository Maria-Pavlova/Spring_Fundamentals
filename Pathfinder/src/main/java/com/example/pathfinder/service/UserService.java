package com.example.pathfinder.service;

import com.example.pathfinder.models.dto.UserDetailsDto;
import com.example.pathfinder.models.dto.UserLoginDto;
import com.example.pathfinder.models.dto.UserRegistrationDto;
import com.example.pathfinder.models.entities.User;
import com.example.pathfinder.repositories.UserRepository;
import com.example.pathfinder.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    public void registerUser(UserRegistrationDto userRegistrationDto){

        if (!userRegistrationDto.getPassword().equals(userRegistrationDto.getConfirmPassword())){
            throw new RuntimeException("passwords.match");
        }

        Optional<User> byEmail = userRepository.findByEmail(userRegistrationDto.getEmail());

        if (byEmail.isPresent()) {
            throw new RuntimeException("User with email [{}] is present.");
        }

        userRepository.save(modelMapper.map(userRegistrationDto, User.class));
        LOGGER.info("User with name [{}] registered.", userRegistrationDto.getUsername());
        }

    public void loginUser(UserLoginDto userLoginDto) {

        Optional<User> optionalUser = this.userRepository.findByUsernameAndPassword(userLoginDto.getUsername(), userLoginDto.getPassword());

        if (optionalUser.isPresent()){
            login(optionalUser.get());
            LOGGER.info("User with name [{}] logged in.", userLoginDto.getUsername());

        }else {
            LOGGER.info("User with name [{}] not found.", userLoginDto.getUsername());
            logout();
        }
    }

    public UserDetailsDto getUserProfile(String username){
        String userUsername = currentUser.getUsername();
        Optional<User> user = userRepository.findByUsername(userUsername);
        return modelMapper.map(user, UserDetailsDto.class);
    }


    private void login(User user){
        currentUser.setLoggedIn(true);
        currentUser.setUsername(user.getUsername());
    }

    private void logout() {
        currentUser.clear();
    }


}


