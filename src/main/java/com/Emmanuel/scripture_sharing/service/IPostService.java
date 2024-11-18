package com.Emmanuel.scripture_sharing.service;

import com.Emmanuel.scripture_sharing.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface IPostService {
    public Post addPost(Integer userId, String content, String languageCode);

    public Post updataPost(Integer id, String content, String languageCode);

    public void deletePost(Integer id);

    public Page<Post> findLatestPostAll(Date lastSeenTimestamp, Pageable pageable);

    public Page<Post> findLatestPostByUser(Integer userId, Date lastSeenTimestamp, Pageable pageable);

    public Post findPostById(Integer postId);
}
