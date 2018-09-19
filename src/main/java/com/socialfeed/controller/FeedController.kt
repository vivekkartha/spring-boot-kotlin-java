package com.socialfeed.controller

import com.socialfeed.exceptions.ResourceNotFoundException
import com.socialfeed.model.Comment
import com.socialfeed.model.FeedPost
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

    @PostMapping("/makePost")
    fun createPost(@RequestBody post: FeedPost) = feedRepository.save(post)

    @PostMapping("/{postId}/createComment")
    fun createComment(@RequestBody comment: Comment, @PathVariable("postId") postId: Long) =
            feedRepository.findById(postId).map { post ->
                comment.post = post
                commentRepository.save(comment)
            }.orElseThrow { ResourceNotFoundException("$postId not found!") }

    @PostMapping("/showAll")
    fun showAllPosts() = feedRepository.findAll()

    @GetMapping(value = "/getComments", params = ["postId"])
    fun getCommentsForPostId(postId: Long) = commentRepository.findByPostId(postId)
}