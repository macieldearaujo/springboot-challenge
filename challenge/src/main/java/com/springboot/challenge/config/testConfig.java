package com.springboot.challenge.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot.challenge.entities.Comment;
import com.springboot.challenge.entities.Post;
import com.springboot.challenge.repositories.CommentRepository;
import com.springboot.challenge.repositories.PostRepository;

@Configuration
@Profile("dev")
public class testConfig implements CommandLineRunner {
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {
        Post p1 = new Post("Exemplo de titulo", "Douglas maciel", "OLA", new Date());
        Post p2 = new Post("Exemplo de ", "Douglas ", "OLA", new Date());
        postRepository.saveAll(Arrays.asList(p1, p2));

        Comment c1 = new Comment("Olá", 2L);
        commentRepository.save(c1);
        
    }
}
