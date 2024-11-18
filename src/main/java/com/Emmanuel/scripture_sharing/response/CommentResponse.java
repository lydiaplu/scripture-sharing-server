package com.Emmanuel.scripture_sharing.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private int id;
    private String content;
    private String languageCode;
    private String createdAt;
    private UserResponse user;
    private PostResponse post;
    private List<CommentTranslationResponse> commentTranslations;
}
