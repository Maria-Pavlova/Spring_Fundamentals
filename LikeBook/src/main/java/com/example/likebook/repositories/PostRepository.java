package com.example.likebook.repositories;

import com.example.likebook.models.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUser_Username(String username);

    List<Post> findAllByUser_UsernameNot(String username);
}
