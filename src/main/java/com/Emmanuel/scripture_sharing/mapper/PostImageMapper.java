package com.Emmanuel.scripture_sharing.mapper;

import com.Emmanuel.scripture_sharing.model.Post;
import com.Emmanuel.scripture_sharing.model.PostImage;
import com.Emmanuel.scripture_sharing.model.User;
import com.Emmanuel.scripture_sharing.response.PostImageResponse;
import com.Emmanuel.scripture_sharing.response.PostResponse;
import com.Emmanuel.scripture_sharing.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostImageMapper {
    PostImageMapper INSTANCE = Mappers.getMapper(PostImageMapper.class);

    PostImageResponse PostImageToPostImageResponse(PostImage postImage);

    PostResponse PostToPostResponse(Post post);

    UserResponse UserToUserResponse(User user);
}
