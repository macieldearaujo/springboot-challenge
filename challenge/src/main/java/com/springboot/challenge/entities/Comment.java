package com.springboot.challenge.entities;

import java.io.Serializable;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    private String description;
    private Long idPost;

    public Comment() {
    }

    public Comment(String description, Long idPost) {
        this.description = description;
        this.idPost = idPost;
    }

    public Comment(String description, Optional<Post> post) {
        this.description = description;
        idPost = post.orElse(null).getId();
    }

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

    @Override
    public String toString() {
        return "Comment [id=" + id + ", description=" + description + ", idPost=" + idPost + "]";
    }
}
