package com.springboot.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.challenge.entities.Comment;
import com.springboot.challenge.services.CommentService;



@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    // @GetMapping("/post/{id}")
    // public void showPostDetails(@PathVariable Long postId) {
        
    // }

    // @PostMapping("/post/{id}")
    // public String sendComment(@PathVariable Long id,Comment comment) {
    //     Comment newComment = new Comment(comment.getDescription(), id);
    //     commentService.saveComment(newComment);
    //     return "";
    // }    
}
