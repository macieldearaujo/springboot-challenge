package com.springboot.challenge.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.challenge.entities.Comment;
import com.springboot.challenge.entities.Post;
import com.springboot.challenge.services.CommentService;
import com.springboot.challenge.services.PostService;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String showFeed(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "feed";
    }

    @GetMapping("/post/{id}")
    public String showPostDetails(@PathVariable Long id, Model model) {
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);

        List<Comment> comment = commentService.findCommentsByPostId(id).stream().
            filter(x -> x.getIdPost().equals(id)).
            collect(Collectors.toList());
        
        model.addAttribute("comment", comment);

        return "post";
    }

    @PostMapping("/post/{id}")
    public String submitComment(@PathVariable Long id, Comment comment) {
        Comment newComment = new Comment(null, comment.getDescription(), id);
        commentService.saveComment(newComment);
        return "redirect:/post/" + id;
    }

    @GetMapping("/new-post")
    public String showFeedPost() {
        return "newPost";
    }

    @PostMapping("/new-post")
    public String submitForm(Post post) {
        Post newPost = new Post(null, post.getTitle(), post.getAuthor(), post.getDescription(), new Date());
        postService.savePost(newPost);

        return "redirect:/";
    }
    
}
