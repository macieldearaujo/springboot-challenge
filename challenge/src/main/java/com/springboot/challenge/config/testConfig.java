package com.springboot.challenge.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot.challenge.entities.Post;
import com.springboot.challenge.repositories.PostRepository;

@Configuration
@Profile("dev")
public class testConfig implements CommandLineRunner {
    
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        Post p1 = new Post(null, "Douglas", new Date(), "Titulo", "Exemplo de descrição");
        postRepository.save(p1);
    }
}
