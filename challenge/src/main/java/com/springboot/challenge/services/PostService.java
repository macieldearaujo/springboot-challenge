package com.springboot.challenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.challenge.entities.Post;
import com.springboot.challenge.exception.UserNotFoundException;
import com.springboot.challenge.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public Post findPostById(Long id) {
        return postRepository.findPostById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }
    
    public void deletePost(Long id) {
        postRepository.deletePostById(id);
    }
}
