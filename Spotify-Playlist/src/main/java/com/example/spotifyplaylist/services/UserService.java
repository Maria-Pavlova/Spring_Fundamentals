package com.example.spotifyplaylist.services;

import com.example.spotifyplaylist.models.dtos.bindingModels.UserLoginModel;
import com.example.spotifyplaylist.models.dtos.bindingModels.UserRegisterModel;
import com.example.spotifyplaylist.models.dtos.viewModels.SongModel;
import com.example.spotifyplaylist.models.entities.Song;
import com.example.spotifyplaylist.models.entities.User;
import com.example.spotifyplaylist.repositories.UserRepository;
import com.example.spotifyplaylist.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    }

    public void login(UserLoginModel userLoginModel) {
        User user = findByUsername(userLoginModel.getUsername()).get();
        currentUser.setUsername(user.getUsername());
        currentUser.setLoggedIn(true);
    }

    public void logout() {
        currentUser.clear();
    }


    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public List<SongModel> findPlaylist() {
        return findByUsername(currentUser.getUsername()).get()
                .getPlaylist().stream()
                .map(song -> modelMapper.map(song, SongModel.class))
                .toList();

    }

    public void addSongToUser(String username, Song song) {
        User user = findByUsername(currentUser.getUsername()).get();

        if ((user.getPlaylist().stream().noneMatch(s -> s.getId().equals(song.getId())))) {
            user.addSongToPlaylist(song);
        }
        userRepository.save(user);
    }

    public Integer findPlaylistDuration() {
       return findPlaylist().stream()
                .map(SongModel::getDuration)
                .reduce(Integer::sum)
                .orElse(0);


    }

    public void removeAllSongsFromPlaylist(String username) {
        User user = userRepository.findByUsername(username).get();
        user.removeAll(user.getPlaylist());
        userRepository.save(user);

    }
}
