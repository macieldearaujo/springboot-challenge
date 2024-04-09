package com.springboot.challenge.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.challenge.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    void deleteCommentById(Long id);
    Optional<Comment> findCommentById(Long id); 
}
