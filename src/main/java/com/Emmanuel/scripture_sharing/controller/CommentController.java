package com.Emmanuel.scripture_sharing.controller;

import com.Emmanuel.scripture_sharing.mapper.CommentMapper;
import com.Emmanuel.scripture_sharing.model.Comment;
import com.Emmanuel.scripture_sharing.response.CommentResponse;
import com.Emmanuel.scripture_sharing.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/add/new-comment")
    public ResponseEntity<CommentResponse> addComment(
            @RequestParam Integer postId,
            @RequestParam Integer userId,
            @RequestParam String content,
            @RequestParam String languageCode
    ) {
        try {
            Comment comment = commentService.addComment(postId, userId, content, languageCode);
            CommentResponse commentResponse = CommentMapper.INSTANCE.commentToCommentResponse(comment);
            return ResponseEntity.ok(commentResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/update/{commentId}")
    public ResponseEntity<CommentResponse> updateComment(
            @PathVariable Integer commentId,
            @RequestParam String content,
            @RequestParam String languageCode
    ) {
        try {
            Comment comment = commentService.updateComment(commentId, content, languageCode);
            CommentResponse commentResponse = CommentMapper.INSTANCE.commentToCommentResponse(comment);
            return ResponseEntity.ok(commentResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<Void> deleteCommentById(
            @PathVariable Integer commentId
    ) {
        commentService.deleteCommentById(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/comment/{commentId}")
    public ResponseEntity<CommentResponse> getCommentById(
            @PathVariable Integer commentId
    ) {
        try {
            Comment comment = commentService.findCommentById(commentId);
            CommentResponse commentResponse = CommentMapper.INSTANCE.commentToCommentResponse(comment);
            return ResponseEntity.ok(commentResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
