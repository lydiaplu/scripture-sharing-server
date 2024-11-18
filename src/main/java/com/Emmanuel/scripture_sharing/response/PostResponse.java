package com.Emmanuel.scripture_sharing.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Integer id;
    private String content;
    private String languageCode;
    private String likeCount;
    private String collectCount;
    private String createdAt;
    private String updatedAt;

    private UserResponse user;
    private List<PostTranslationResponse> postTranslations;
    private List<CommentResponse> comments;
    private List<PostImageResponse> postImages;

//    public PostResponse(Integer id, String content, String languageCode, Integer likeCount, Integer collectCount, ZonedDateTime createdAt, ZonedDateTime updatedAt,
//                        UserResponse user, List<PostTranslationResponse> postTranslations, List<CommentResponse> comments, List<PostImageResponse> postImages
//    ) {
//        this.id = id;
//        this.content= content;
//        this.languageCode = languageCode;
//        this.likeCount = String.valueOf(likeCount);
//        this.collectCount = String.valueOf(collectCount);
//        this.createdAt = String.valueOf(createdAt);
//        this.updatedAt = String.valueOf(updatedAt);
//
//        this.user = user;
//        this.postTranslations = postTranslations;
//        this.comments = comments;
//        this.postImages = postImages;
//    }
}
