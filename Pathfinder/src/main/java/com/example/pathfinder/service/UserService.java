package com.example.pathfinder.service;

import com.example.pathfinder.models.dto.UserLoginDto;
import com.example.pathfinder.models.dto.UserRegistrationDto;
import com.example.pathfinder.models.entities.User;
import com.example.pathfinder.repositories.UserRepository;
import com.example.pathfinder.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public void registerUser(UserRegistrationDto userRegistrationDto){

        if (!userRegistrationDto.getPassword().equals(userRegistrationDto.getConfirmPassword())){
            throw new RuntimeException("passwords.match");
        }

        Optional<User> byEmail = userRepository.findByEmail(userRegistrationDto.getEmail());

        if (byEmail.isPresent()) {
            throw new RuntimeException("User with email {} is present.");
        }

        User user = new User(userRegistrationDto.getUsername(),
                userRegistrationDto.getFullname(),
                userRegistrationDto.getAge(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getPassword());
        userRepository.save(user);

        }

    public void loginUser(UserLoginDto userLoginDto) {

        Optional<User> optionalUser = this.userRepository.findByUsernameAndPassword(userLoginDto.getUsername(), userLoginDto.getPassword());

        if (optionalUser.isPresent()){
            login(optionalUser.get());
        }else {
            LOGGER.info("User with name [{}] not found.", userLoginDto.getUsername());
            logout();
        }
    }

    private void login(User user){
        currentUser.setLoggedIn(true);
        currentUser.setUsername(user.getUsername());
    }

    private void logout() {
        currentUser.clear();
    }


}


