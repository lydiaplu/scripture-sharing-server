package com.Emmanuel.scripture_sharing.mapper;

import com.Emmanuel.scripture_sharing.model.User;
import com.Emmanuel.scripture_sharing.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse userToUserResponse(User user);
}
