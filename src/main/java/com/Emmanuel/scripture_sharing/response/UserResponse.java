package com.Emmanuel.scripture_sharing.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Integer id;
    private String email;
    private String username;
    private String provider;
    private String createdAt;
    private String active;
    private UserProfileResponse userProfile;
    private List<PostResponse> posts;
    private List<PostImageResponse> postImages;
    private List<CommentResponse> comments;
}
