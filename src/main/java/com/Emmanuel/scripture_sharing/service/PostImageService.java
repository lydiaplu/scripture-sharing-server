package com.Emmanuel.scripture_sharing.service;

import com.Emmanuel.scripture_sharing.model.PostImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostImageService implements IPostImageService {
    @Override
    public PostImage addPostImage(Integer postId, Integer userId, String s3Url) {
        return null;
    }

    @Override
    public void deletePostImagesByPost(Integer postId) {

    }

    @Override
    public void deletePostImageById(Integer id) {

    }
}
