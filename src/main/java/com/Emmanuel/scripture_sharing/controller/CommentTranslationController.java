package com.Emmanuel.scripture_sharing.controller;

import com.Emmanuel.scripture_sharing.mapper.CommentTranslationMapper;
import com.Emmanuel.scripture_sharing.model.CommentTranslation;
import com.Emmanuel.scripture_sharing.response.CommentTranslationResponse;
import com.Emmanuel.scripture_sharing.service.CommentTranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/commentTranslations")
public class CommentTranslationController {
    private final CommentTranslationService commentTranslationService;

    @PostMapping("/add/new-comment-translation")
    public ResponseEntity<CommentTranslationResponse> addCommentTranslation(
            @RequestParam Integer commentId,
            @RequestParam String translatedContent,
            @RequestParam String languageCode
    ) {
        try {
            CommentTranslation commentTranslation = commentTranslationService.addCommentTranslation(commentId, translatedContent, languageCode);
            CommentTranslationResponse commentTranslationResponse = CommentTranslationMapper.INSTANCE.CommentTranslationToCommentTranslationResponse(commentTranslation);
            return ResponseEntity.ok(commentTranslationResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<Void> deleteAllCommentTranslationByCommentId(
            @PathVariable Integer commentId
    ) {
        commentTranslationService.deleteAllCommentTranslationByCommentId(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
