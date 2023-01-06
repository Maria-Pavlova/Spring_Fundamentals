package com.mobilele.services;

import com.mobilele.utils.mapper.UserMapper;
import com.mobilele.models.dtos.UserLoginDto;
import com.mobilele.models.dtos.UserRegisterModel;
import com.mobilele.models.entities.User;
import com.mobilele.repositories.UserRepository;
import com.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;
    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, CurrentUser currentUser,
                       PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }


    public boolean login(UserLoginDto loginDto){
        Optional<User> optionalUser = userRepository.findByUsername(loginDto.getUsername());

        if (optionalUser.isEmpty()){
            LOGGER.info("User with name [{}] not found.", loginDto.getUsername());
            return false;
        }

        var rawPassword = loginDto.getPassword();
        var encodedPassword  = optionalUser.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success){
            login(optionalUser.get());
        }else {
            logout();
        }
        return success;
    }

    private void login(User user){
        currentUser.setLoggedIn(true);
        currentUser.setUsername(user.getFirstName() + " " + user.getLastName());
    }

    public void logout(){
        currentUser.clear();
    }

    public void registerAndLogin (UserRegisterModel userRegisterModel) {

       User newUser = userMapper.userModelToUser(userRegisterModel);
       newUser.setPassword(passwordEncoder.encode(userRegisterModel.getPassword()));

       newUser = userRepository.save(newUser);
       login(newUser);
    }
}
