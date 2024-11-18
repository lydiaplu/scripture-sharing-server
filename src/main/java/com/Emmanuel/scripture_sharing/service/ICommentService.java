package com.Emmanuel.scripture_sharing.service;

import com.Emmanuel.scripture_sharing.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICommentService {
    public Comment addComment(Integer postId, Integer userId, String content, String languageCode);

    public Comment updateComment(Integer commentId, String content, String languageCode);

    public void deleteCommentById(Integer commentId);

    public void deleteCommentsByPost(Integer postId);

    public void deleteCommentsByUser(Integer userId);

    public Page<Comment> findCommentByPost(Integer postId, Pageable pageable);

    public Comment findCommentById(Integer commentId);
}
