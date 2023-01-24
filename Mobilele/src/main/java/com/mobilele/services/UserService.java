package com.mobilele.services;

import com.mobilele.models.entities.UserRole;
import com.mobilele.models.enums.Role;
import com.mobilele.utils.mapper.UserMapper;
import com.mobilele.models.dtos.UserLoginDto;
import com.mobilele.models.dtos.UserRegisterModel;
import com.mobilele.models.entities.User;
import com.mobilele.repositories.UserRepository;
import com.mobilele.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final ModelMapper modelMapper;


    public UserService(UserRepository userRepository, CurrentUser currentUser,
                       PasswordEncoder passwordEncoder, UserMapper userMapper,
                       ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.modelMapper = modelMapper;
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
            LOGGER.info("User with name [{}] logged in.", loginDto.getUsername());
        }else {
            logout();
        }
        return success;
    }

    private void login(User user){

        List<Role> roles = user
                .getRoles()
                .stream()
                .map(UserRole::getRole)
                .collect(Collectors.toList());

        currentUser.setLoggedIn(true);
        currentUser.setUsername(user.getFirstName() + " " + user.getLastName());
        currentUser.setUserRoles(roles);
    }

    public void logout(){
        currentUser.clear();
    }

    public void registerAndLogin (UserRegisterModel userRegisterModel) {

      // User newUser = userMapper.userModelToUser(userRegisterModel);
        User newUser = modelMapper.map(userRegisterModel, User.class);
        newUser.setActive(true);
        newUser.setPassword(passwordEncoder.encode(userRegisterModel.getPassword()));

       newUser = userRepository.save(newUser);
       login(newUser);
    }

    public boolean isAuthenticate(UserLoginDto userLoginDto){
        Optional<User> optionalUser = userRepository.findByUsername(userLoginDto.getUsername());
        if (optionalUser.isPresent()){
            String  rawPassword = userLoginDto.getPassword();
            String  encodedPassword  = optionalUser.get().getPassword();
            return passwordEncoder.matches(rawPassword, encodedPassword);
        }
       return false;

    }
}
