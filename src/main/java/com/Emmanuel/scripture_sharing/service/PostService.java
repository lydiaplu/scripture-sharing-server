package com.Emmanuel.scripture_sharing.service;

import com.Emmanuel.scripture_sharing.exception.ResourceNotFoundException;
import com.Emmanuel.scripture_sharing.model.Post;
import com.Emmanuel.scripture_sharing.model.User;
import com.Emmanuel.scripture_sharing.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    private final PostRepository postRepository;
    private final UserService userService;

    @Override
    public Post addPost(Integer userId, String content, String languageCode) {
        User theUser = userService.findUserById(userId);

        Post post = new Post();
        post.setUser(theUser);
        post.setContent(content);
        post.setLanguageCode(languageCode);
        post.setLikeCount(0);
        post.setCollectCount(0);
        post.setCreatedAt(ZonedDateTime.now());

        return postRepository.save(post);

        // translate post's content and add to post_translation table
    }

    @Override
    @Transactional
    public Post updataPost(Integer id, String content, String languageCode) {
        Post thePost = findPostById(id);

        thePost.setContent(content);
        thePost.setLanguageCode(languageCode);
        thePost.setUpdatedAt(ZonedDateTime.now());

        // delete old post_translation


        return postRepository.save(thePost);
    }

    @Override
    public void deletePost(Integer id) {
        Post thePost = findPostById(id);
        if(thePost != null){
            postRepository.deleteById(id);
        }
    }

    @Override
    public Page<Post> findLatestPostAll(Date lastSeenTimestamp, Pageable pageable) {
        return postRepository.findLatestPostsAll(lastSeenTimestamp, pageable);
    }

    @Override
    public Page<Post> findLatestPostByUser(Integer userId, Date lastSeenTimestamp, Pageable pageable) {
        return null;
    }

    @Override
    public Post findPostById(Integer postId) {
        return postRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post not found with id: " + postId));
    }
}
