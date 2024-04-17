package com.springboot.challenge.entities;

import java.io.Serializable;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Long idPost;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonBackReference
    private Post post;

    public Comment() {
    }

    public Comment(Long id, String description, Long idPost) {
        this.id = id;
        this.description = description;
        this.idPost = idPost;
    }

    public Comment(String description, Optional<Post> post) {
        this.description = description;
        idPost = post.orElse(null).getId();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getIdPost() {
        return idPost;
    }
    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }
    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
    @Override
    public String toString() {
        return "Comment [id=" + id + ", description=" + description + ", idPost=" + idPost + "]";
    }}