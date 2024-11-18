package com.Emmanuel.scripture_sharing.service;

import com.Emmanuel.scripture_sharing.exception.ResourceNotFoundException;
import com.Emmanuel.scripture_sharing.model.Comment;
import com.Emmanuel.scripture_sharing.model.Post;
import com.Emmanuel.scripture_sharing.model.User;
import com.Emmanuel.scripture_sharing.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;
    private final UserService userService;

    @Override
    public Comment addComment(Integer postId, Integer userId, String content, String languageCode) {
        Post thePost = postService.findPostById(postId);
        User theUser = userService.findUserById(userId);

        Comment comment = new Comment();
        comment.setPost(thePost);
        comment.setUser(theUser);
        comment.setContent(content);
        comment.setLanguageCode(languageCode);
        comment.setCreatedAt(ZonedDateTime.now());

        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Integer commentId, String content, String languageCode) {
        return null;
    }

    @Override
    public void deleteCommentById(Integer commentId) {
        Comment theComment = findCommentById(commentId);
        if(theComment != null) {
            commentRepository.deleteById(commentId);
        }
    }

    @Override
    public void deleteCommentsByPost(Integer postId) {

    }

    @Override
    public void deleteCommentsByUser(Integer userId) {

    }

    @Override
    public Page<Comment> findCommentByPost(Integer postId, Pageable pageable) {
        return null;
    }

    @Override
    public Comment findCommentById(Integer commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + commentId));
    }
}
