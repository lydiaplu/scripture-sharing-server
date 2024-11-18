package com.Emmanuel.scripture_sharing.service;

import com.Emmanuel.scripture_sharing.exception.ResourceNotFoundException;
import com.Emmanuel.scripture_sharing.model.Comment;
import com.Emmanuel.scripture_sharing.model.CommentTranslation;
import com.Emmanuel.scripture_sharing.repository.CommentTranslationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentTranslationService implements ICommentTranslationService {
    private final CommentTranslationRepository commentTranslationRepository;
    private final CommentService commentService;

    @Override
    public CommentTranslation addCommentTranslation(Integer commentId, String translatedContent, String languageCode) {
        Comment comment = commentService.findCommentById(commentId);

        CommentTranslation commentTranslation = new CommentTranslation();
        commentTranslation.setComment(comment);
        commentTranslation.setTranslatedContent(translatedContent);
        commentTranslation.setLanguageCode(languageCode);

        return commentTranslationRepository.save(commentTranslation);

    }

    @Override
    public CommentTranslation updateCommentTranslation(Integer id, Integer commentId, String translatedContent, String languageCode) {
        return null;
    }

    @Override
    public void deleteAllCommentTranslationByCommentId(Integer commentId) {
        commentTranslationRepository.deleteAllCommentTranslationByCommentId(commentId);
    }

    @Override
    public void deleteCommentTranslationById(Integer id) {

    }

    @Override
    public CommentTranslation findCommentTranslationByCommentIdAndLanguageCode(Integer commentId, String languageCode) {
        return commentTranslationRepository.findCommentTranslationByCommentIdAndLanguageCode(commentId, languageCode)
                .orElseThrow(()->new ResourceNotFoundException(String.format("CommentTranslation not found with commentId: %d, languageCode: %s", commentId, languageCode)));
    }
}
