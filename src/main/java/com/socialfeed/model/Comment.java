package com.socialfeed.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @SequenceGenerator(name = "comment_seq")
    @GeneratedValue(generator = "comment_seq")
    private Long id;
    private String message;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "post_id", referencedColumnName = "post_id",nullable = false)
    @JsonBackReference
    private FeedPost post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FeedPost getPost() {
        return post;
    }

    public void setPost(FeedPost post) {
        this.post = post;
    }
}
