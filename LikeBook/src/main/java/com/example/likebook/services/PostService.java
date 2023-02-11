package com.example.likebook.services;

import com.example.likebook.models.dtos.bindingModels.AddPostModel;
import com.example.likebook.models.dtos.viewModels.PostViewModel;
import com.example.likebook.models.entities.Post;
import com.example.likebook.repositories.PostRepository;
import com.example.likebook.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final MoodService moodService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public PostService(PostRepository postRepository, ModelMapper modelMapper,
                       MoodService moodService, UserService userService, CurrentUser currentUser) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.moodService = moodService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    public void addPost(AddPostModel postModel) {
        Post post = modelMapper.map(postModel, Post.class);
        post.setMood(moodService.findByName(postModel.getMood()));
        post.setUser(userService.findByUsername(currentUser.getUsername()).get());
        //todo userlikes??
        postRepository.saveAndFlush(post);
    }

    public void removePostById(Long id) {
        postRepository.deleteById(id);
    }

    public List<PostViewModel> findLoggedUsersPost() {
       return postRepository.findAllByUser_Username(currentUser.getUsername())
                .stream()
                .map(post -> modelMapper.map(post, PostViewModel.class))
                .toList();
    }

    public List<PostViewModel> findOtherUsersPosts() {
        return postRepository.findAllByUser_UsernameNot(currentUser.getUsername())
                .stream()
                .map(post -> modelMapper.map(post, PostViewModel.class))
                .toList();
    }

    public void likePost(Long id) {
        Post post = postRepository.findById(id).get();
               post.setLikes(post.getLikes() + 1);
               postRepository.save(post);
        System.out.println(post.getLikes());

    }

    public Integer findCountOtherUsersPosts() {
        return postRepository.findAllByUser_UsernameNot(currentUser.getUsername())
                .stream()
                .map(post -> modelMapper.map(post, PostViewModel.class))
                .toList().size();
    }
}
