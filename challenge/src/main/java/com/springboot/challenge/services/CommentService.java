package com.springboot.challenge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Comment> findCommentsByPostId(Long id) {
        List<Comment> allComments = commentRepository.findAll().stream()
        .filter(comment -> comment.getIdPost().equals(id))
        .collect(Collectors.toList());
        return allComments;
    }
    
    public void deleteComment(Long id) {
        commentRepository.deleteCommentById(id);
    }
}
