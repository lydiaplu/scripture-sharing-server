package com.Emmanuel.scripture_sharing.service;

import com.Emmanuel.scripture_sharing.model.PostTranslation;

public interface IPostTranslationService {
    public PostTranslation addPostTranslation(Integer postId, String translatedContent, String languageCode);

    public PostTranslation updatePostTranslation(Integer postId, String translatedContent, String languageCode);

    public void deleteAllPostTranslationByPostId(Integer postId);

    public PostTranslation findPostTranslationByPostIdAndLanguageCode(Integer postId, String languageCode);
}
