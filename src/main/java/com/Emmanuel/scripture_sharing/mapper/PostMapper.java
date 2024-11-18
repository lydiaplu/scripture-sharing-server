package com.Emmanuel.scripture_sharing.mapper;

import com.Emmanuel.scripture_sharing.model.*;
import com.Emmanuel.scripture_sharing.response.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostResponse postToPostResponse(Post post);

    UserResponse userToUserResponse(User user);
    PostTranslationResponse postTranslationToPostTranslationResponse(PostTranslation postTranslation);
    CommentResponse commentToCommentResponse(Comment comment);
    PostImageResponse postImageToPostImageResponse(PostImage postImage);
}
