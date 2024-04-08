package com.springboot.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.challenge.services.PostService;

@Controller
public class PostController {
    
    @Autowired
    private PostService postService;

    @GetMapping("/feed")
    public String showFeed() {
        return "feed";
    }

    @GetMapping("/new-post")
    public String showFeedPost() {
        return "newPost";
    }
}
