package com.Emmanuel.scripture_sharing.controller;

import com.Emmanuel.scripture_sharing.mapper.PostTranslationMapper;
import com.Emmanuel.scripture_sharing.model.PostTranslation;
import com.Emmanuel.scripture_sharing.response.PostTranslationResponse;
import com.Emmanuel.scripture_sharing.service.PostTranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/postTranslations")
public class PostTranslationController {
    private final PostTranslationService postTranslationService;

    @PostMapping("/add/new-post-translation")
    public ResponseEntity<PostTranslationResponse> addPostTranslation(
            @RequestParam Integer postId,
            @RequestParam String translatedContent,
            @RequestParam String languageCode
    ) {
        try {
            PostTranslation postTranslation = postTranslationService.addPostTranslation(postId, translatedContent, languageCode);
            PostTranslationResponse postTranslationResponse = PostTranslationMapper.INSTANCE.PostTranslationToPostTranslationResponse(postTranslation);
            return ResponseEntity.ok(postTranslationResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<Void> deleteAllPostTranslationByPostId(
            @PathVariable Integer postId
    ) {
        postTranslationService.deleteAllPostTranslationByPostId(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
