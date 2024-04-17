package com.springboot.challenge.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "posts")
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String author;

    @Column(nullable=false, length = 50000)
    private String description;

    @Transient
    private Photo image; // not implemented

    @Column(nullable=false)
    private Date date;

    @Transient
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy (HH:mm)");

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(Long id, String title, String author, String description, Date date) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.date = date;
    }

    public Long getId() {
        return id;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Photo getImage() {
        return image;
    }
    public void setImage(Photo image) {
        this.image = image;
    }
    public List<Comment> getComments() {
    return comments;
    }
    public void setComments(List<Comment> comments) {
    this.comments = comments;
    }   

    public String commentsNumber() {
        return comments.size() + " comments";
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public String timeAgo() {
        Date nowDate = new Date();
        long diffMilliseconds = nowDate.getTime() - date.getTime();
        long diffSeconds = TimeUnit.MILLISECONDS.toSeconds(diffMilliseconds);
        long diffMinutes = TimeUnit.MILLISECONDS.toMinutes(diffMilliseconds);
        long diffHours = TimeUnit.MILLISECONDS.toHours(diffMilliseconds);
        long diffDays = TimeUnit.MILLISECONDS.toDays(diffMilliseconds);

        if (diffSeconds <= 59) {
            return diffSeconds + " sec";
        } else if (diffMinutes <= 59) {
            return diffMinutes + " min";
        } else if (diffHours <= 23) {
            return diffHours + " hours";
        } else {
            return diffDays + " days";
        }
    }

    public String formattedDate() {
        return sdf.format(this.getDate());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}