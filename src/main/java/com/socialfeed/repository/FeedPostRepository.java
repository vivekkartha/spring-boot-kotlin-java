package com.socialfeed.repository;

import com.socialfeed.model.FeedPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedPostRepository extends JpaRepository<FeedPost,Long> {
}
