package com.Emmanuel.scripture_sharing.service;

import com.Emmanuel.scripture_sharing.model.PostImage;

public interface IPostImageService {
    public PostImage addPostImage(Integer postId, Integer userId, String s3Url);

    public void deletePostImagesByPost(Integer postId);

    public void deletePostImageById(Integer id);
}
