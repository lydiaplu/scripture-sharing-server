package com.Emmanuel.scripture_sharing.controller;

import com.Emmanuel.scripture_sharing.mapper.PostMapper;
import com.Emmanuel.scripture_sharing.model.Post;
import com.Emmanuel.scripture_sharing.response.PostResponse;
import com.Emmanuel.scripture_sharing.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @PostMapping("/add/new-post")
    public ResponseEntity<PostResponse> addPost(
            @RequestParam Integer userId,
            @RequestParam String content,
            @RequestParam String languageCode
    ) {
        try {
            Post savedPost = postService.addPost(userId, content, languageCode);
            PostResponse postResponse = PostMapper.INSTANCE.postToPostResponse(savedPost);
            return ResponseEntity.ok(postResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/update/{postId}")
    public ResponseEntity<PostResponse> updateResponse(
            @PathVariable Integer postId,
            @RequestParam String content,
            @RequestParam String languageCode
    ) {
        try{
            Post post = postService.updataPost(postId, content, languageCode);
            PostResponse postResponse = PostMapper.INSTANCE.postToPostResponse(post);
            return ResponseEntity.ok(postResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/newest")
    public ResponseEntity<Page<PostResponse>> getLatestPostsAll(
            @RequestParam Date lastSeenTimestamp,
            @RequestParam Integer page,
            @RequestParam Integer size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = postService.findLatestPostAll(lastSeenTimestamp, pageable);
        Page<PostResponse> postResponses = posts.map(PostMapper.INSTANCE::postToPostResponse);
        return ResponseEntity.ok(postResponses);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<PostResponse> getPostById(
            @PathVariable Integer postId
    ) {
        try{
            Post thePost = postService.findPostById(postId);
            PostResponse thePostResponse = PostMapper.INSTANCE.postToPostResponse(thePost);
            return ResponseEntity.ok(thePostResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
