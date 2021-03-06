package com.socialfeed.controller

import com.socialfeed.exceptions.ResourceNotFoundException
import com.socialfeed.model.Comment
import com.socialfeed.model.FeedPost
import com.socialfeed.repository.AccountRepository
import com.socialfeed.repository.CommentRepository
import com.socialfeed.repository.FeedPostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class FeedController {
    @Autowired
    private lateinit var feedRepository: FeedPostRepository
    @Autowired
    private lateinit var commentRepository: CommentRepository
    @Autowired
    private lateinit var accountRepository: AccountRepository

    //TODO: Insert user obj to feedpost(back ref)
    @PostMapping("/{userId}/makePost")
    fun createPost(@RequestBody post: FeedPost, @PathVariable userId: Long): FeedPost {
        return accountRepository.findById(userId).map { user ->
            post.user = user
            feedRepository.save(post)
        }.orElseThrow { ResourceNotFoundException("$userId not found!") }
    }

    @PostMapping("/{postId}/createComment")
    fun createComment(@RequestBody comment: Comment, @PathVariable("postId") postId: Long): Comment {
        return feedRepository.findById(postId).map { post ->
            comment.post = post
            commentRepository.save(comment)
        }.orElseThrow { ResourceNotFoundException("$postId not found!") }
    }

    @GetMapping("/showAll")
    fun showAllPosts(): List<FeedPost> = feedRepository.findAll()

    @GetMapping(value = ["/getComments"], params = ["postId"])
    fun getCommentsForPostId(postId: Long): List<Comment> = commentRepository.findByPostId(postId)

    @GetMapping(value = ["/getPosts"], params = ["userId"])
    fun getPostsByUserId(userId: Long): List<FeedPost> = feedRepository.findByUserId(userId)
}
