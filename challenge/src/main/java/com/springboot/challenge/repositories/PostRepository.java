package com.springboot.challenge.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.challenge.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    void deletePostById(Long id);
    Optional<Post> findPostById(Long id); 
}