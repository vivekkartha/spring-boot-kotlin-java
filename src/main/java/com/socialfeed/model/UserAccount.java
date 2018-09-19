package com.socialfeed.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class UserAccount {
    @Id
    @SequenceGenerator(name = "user_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "user_id")
    private Long id;
    @Size(max = 100)
    private String name;
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<FeedPost> feedPosts;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValidUser() {
        return name != null && password != null;
    }

    public List<FeedPost> getFeedPosts() {
        return feedPosts;
    }

    public void setFeedPosts(List<FeedPost> feedPosts) {
        this.feedPosts = feedPosts;
    }
}
