package com.example.coffeeshop.service;

import com.example.coffeeshop.models.dto.bindingModels.UserLoginModel;
import com.example.coffeeshop.models.dto.bindingModels.UserRegisterModel;
import com.example.coffeeshop.models.dto.viewModels.UserViewModel;
import com.example.coffeeshop.models.entity.User;
import com.example.coffeeshop.models.security.CurrentUser;
import com.example.coffeeshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ModelMapper modelMapper,
                       CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
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
            return false;
        }
        String  rawPassword = userLoginModel.getPassword();
        String  encodedPassword  = optionalUser.get().getPassword();

        if (passwordEncoder.matches(rawPassword, encodedPassword)) {
            login(optionalUser.get());
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

    public List<UserViewModel> findCountOfOrdersByEmployee() {
       return userRepository.findCountOfOrdersByEmployee()
                .stream()
                .map(user -> {
                    UserViewModel viewModel = modelMapper.map(user, UserViewModel.class);
                    viewModel.setCountOfOrders(user.getOrders().size());
                    return viewModel;
                })
                .toList();
    }
}
