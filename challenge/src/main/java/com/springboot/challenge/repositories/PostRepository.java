package com.springboot.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.challenge.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    void deletePostById(Long id);
    Post findPostById(Long id); 
}
