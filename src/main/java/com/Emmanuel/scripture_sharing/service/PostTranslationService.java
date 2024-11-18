package com.Emmanuel.scripture_sharing.service;

import com.Emmanuel.scripture_sharing.exception.ResourceNotFoundException;
import com.Emmanuel.scripture_sharing.model.Post;
import com.Emmanuel.scripture_sharing.model.PostTranslation;
import com.Emmanuel.scripture_sharing.repository.PostTranslationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostTranslationService implements IPostTranslationService {
    private final PostTranslationRepository postTranslationRepository;
    private final PostService postService;

    @Override
    public PostTranslation addPostTranslation(Integer postId, String translatedContent, String languageCode) {
        Post thePost = postService.findPostById(postId);

        PostTranslation postTranslation = new PostTranslation();
        postTranslation.setPost(thePost);
        postTranslation.setTranslatedContent(translatedContent);
        postTranslation.setLanguageCode(languageCode);

        return postTranslationRepository.save(postTranslation);
    }

    @Override
    public PostTranslation updatePostTranslation(Integer postId, String translatedContent, String languageCode) {
        return null;
    }

    @Override
    public void deleteAllPostTranslationByPostId(Integer postId) {
        postTranslationRepository.deleteAllPostTranslationByPostId(postId);
    }

    @Override
    public PostTranslation findPostTranslationByPostIdAndLanguageCode(Integer postId, String languageCode) {
        return postTranslationRepository.findPostTranslationByPostIdAndLanguageCode(postId, languageCode)
                .orElseThrow(()->new ResourceNotFoundException(String.format("PostTranslation not found with postId: %d, languageCode: %s", postId, languageCode)));
    }

}
