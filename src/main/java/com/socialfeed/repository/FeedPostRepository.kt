package com.socialfeed.repository

import com.socialfeed.model.FeedPost
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FeedPostRepository : JpaRepository<FeedPost, Long> {
    fun findByUserId(userId: Long): List<FeedPost>
}
