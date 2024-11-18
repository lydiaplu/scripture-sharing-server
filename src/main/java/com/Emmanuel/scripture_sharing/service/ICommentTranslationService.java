package com.Emmanuel.scripture_sharing.service;

import com.Emmanuel.scripture_sharing.model.CommentTranslation;

public interface ICommentTranslationService {
    public CommentTranslation addCommentTranslation(Integer commentId, String translatedContent, String languageCode);

    public CommentTranslation updateCommentTranslation(Integer id, Integer commentId, String translatedContent, String languageCode);

    public void deleteAllCommentTranslationByCommentId(Integer postId);

    public void deleteCommentTranslationById(Integer id);

    public CommentTranslation findCommentTranslationByCommentIdAndLanguageCode(Integer postId, String languageCode);
}
