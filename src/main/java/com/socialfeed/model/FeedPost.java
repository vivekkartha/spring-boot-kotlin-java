package com.socialfeed.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "feed_post")
public class FeedPost {
    @Id
    @SequenceGenerator(name = "feed_seq")
    @GeneratedValue(generator = "feed_seq")
    @Column(name = "post_id")
    private Long id;
    private String post;
    private String likes;
    @OneToMany(mappedBy = "post", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Comment> comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }


    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
