package com.springboot.challenge.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot.challenge.entities.Comment;
import com.springboot.challenge.entities.Post;
import com.springboot.challenge.repositories.PostRepository;
import com.springboot.challenge.services.CommentService;

@Configuration
@Profile("dev")
public class testConfig implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentService commentService;

    @Override
    public void run(String... args) throws Exception {
        Post p1 = new Post(null, "Onde consigo investir na Artesanal Investimentos?", "Pedro da Silva", "Olá pessoal, gostaria de saber em qual plataforma eu consigo achar os fundos da Artesanal Investimentos. Fiquei realmente encantado com a empresa!", new Date());
        Post p2 = new Post(null, "Existe fundo de renda fixa da Artesanal?", "Douglas ", "Boa tarde, eu gostaria de saber se a Artesanal disponibiliza fundo de renda fixa. Estou iniciando no mercado financeiro e gostaria de começar com um investimento mais seguro.", new Date());
        postRepository.saveAll(Arrays.asList(p1, p2));

        Comment c1 = new Comment(null, "Sim, com certeza, com 100 reais você já consegue começar investindo. Qualquer dúvida estou a disposição.", p1.getId());
        Comment c2 = new Comment(null, "Existem diversos bancos e corretoras para você investir na Artesanal, dentre elas: NU Invest, Btg Pactual, Empiricus, Singulare, entre outros.", p2.getId());
        commentService.saveAll(Arrays.asList(c1, c2));
    }
}
