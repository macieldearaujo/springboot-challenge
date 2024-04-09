package com.springboot.challenge.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.challenge.entities.Post;
import com.springboot.challenge.services.PostService;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String showFeed(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "feed";
    }

    @GetMapping("/new-post")
    public String showFeedPost() {
        return "newPost";
    }

    @PostMapping("/new-post")
    public String submitForm(Post post) {
        Post newPost = new Post(post.getTitle(), post.getAuthor(), post.getDescription(), new Date());
        postService.savePost(newPost);

        System.out.println("DONE!!");
        return "redirect:/";
    }
    
}
