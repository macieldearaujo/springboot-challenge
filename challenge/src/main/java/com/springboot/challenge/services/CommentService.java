package com.springboot.challenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.challenge.entities.Comment;
import com.springboot.challenge.exception.CommentNotFoundException;
import com.springboot.challenge.repositories.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment saveComment(Comment Comment) {
        return commentRepository.save(Comment);
    }

    public Comment findCommentById(Long id) {
        return commentRepository.findCommentById(id).orElseThrow(() -> new CommentNotFoundException("Comment by id " + id + " was not found."));
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment updateComment(Comment Comment) {
        return commentRepository.save(Comment);
    }
    
    public void deleteComment(Long id) {
        commentRepository.deleteCommentById(id);
    }
}