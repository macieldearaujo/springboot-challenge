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
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.challenge.entities.Comment;
import com.springboot.challenge.entities.Post;
import com.springboot.challenge.services.CommentService;
import com.springboot.challenge.services.PostService;

import jakarta.transaction.Transactional;


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

    @GetMapping("/new-post")
    public String showFeed() {
        return "newPost";
    }

    @PostMapping("/new-post")
    public String submitPost(Post post) {
        Post newPost = new Post(null, post.getTitle(), post.getAuthor(), post.getDescription(), new Date());
        postService.savePost(newPost);

        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String showPosts(@PathVariable Long id, Model model) {
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);
        List<Comment> comment = commentService.findCommentsByPostId(id).stream().filter(x -> x.getIdPost().equals(id))
                .collect(Collectors.toList());

        model.addAttribute("comment", comment);

        return "post";
    }

    @PostMapping("/post/{id}")
    @Transactional
    public String submitComment(@PathVariable Long id,
            @RequestParam(value = "commentId", required = false) Long commentId, Comment comment) {
        if (commentId == null) {
            Comment createNewComment = new Comment(null, comment.getDescription(), id);
            commentService.saveComment(createNewComment);
        } else {
            Comment findComment = commentService.findCommentById(commentId);
            findComment.setDescription(comment.getDescription());
            commentService.saveComment(findComment);
        }
        return "redirect:/post/" + id;
    }

    @PostMapping("/post/{id}/comment/{commentId}/delete")
    public String deleteComment(@PathVariable Long id, @PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return "redirect:/post/" + id;
    }    
}