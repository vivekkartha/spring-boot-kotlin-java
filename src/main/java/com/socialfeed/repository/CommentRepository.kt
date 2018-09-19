package com.socialfeed.repository

import com.socialfeed.model.Comment
import com.socialfeed.model.FeedPost
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : JpaRepository<Comment, Long> {
    fun findByPostId(postId: Long):List<Comment>
}
