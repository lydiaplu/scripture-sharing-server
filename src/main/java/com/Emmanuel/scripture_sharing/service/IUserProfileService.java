package com.Emmanuel.scripture_sharing.service;

import com.Emmanuel.scripture_sharing.model.UserProfile;
import com.Emmanuel.scripture_sharing.request.UserProfileRequest;

public interface IUserProfileService {
    public UserProfile addUserProfile(UserProfileRequest userProfileRequest);

    public UserProfile updateUserProfile(Integer id, UserProfileRequest userProfileRequest);

    public void deleteUserProfile(Integer userId);

    public UserProfile findUserProfile(Integer userId);
}
