package com.socialfeed.controller;

import com.socialfeed.model.FeedPost;
import com.socialfeed.repository.FeedPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedController {

    @Autowired
    private FeedPostRepository feedRepository;

    @PostMapping("/create")
    public boolean createPost(@RequestBody FeedPost post) {
        FeedPost fp = new FeedPost();
        fp.setLikes(post.getLikes());
        fp.setPost(post.getPost());
        fp.setId(post.getId());
        feedRepository.save(fp);

        return false;
    }

    @GetMapping("/show")
    public List<FeedPost> showAllPosts() {
        return feedRepository.findAll();
    }
}
