package com.Emmanuel.scripture_sharing.mapper;

import com.Emmanuel.scripture_sharing.model.User;
import com.Emmanuel.scripture_sharing.model.UserProfile;
import com.Emmanuel.scripture_sharing.response.UserProfileResponse;
import com.Emmanuel.scripture_sharing.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserProfileResponseMapper {
    UserProfileResponseMapper INSTANCE = Mappers.getMapper(UserProfileResponseMapper.class);

    UserProfileResponse UserProfileToUserProfileResponse(UserProfile userProfile);

    UserResponse UserToUserResponse(User user);
}
