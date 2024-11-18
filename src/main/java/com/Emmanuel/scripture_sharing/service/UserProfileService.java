package com.Emmanuel.scripture_sharing.service;

import com.Emmanuel.scripture_sharing.model.UserProfile;
import com.Emmanuel.scripture_sharing.request.UserProfileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService implements IUserProfileService {
    @Override
    public UserProfile addUserProfile(UserProfileRequest userProfileRequest) {
        return null;
    }

    @Override
    public UserProfile updateUserProfile(Integer id, UserProfileRequest userProfileRequest) {
        return null;
    }

    @Override
    public void deleteUserProfile(Integer userId) {

    }

    @Override
    public UserProfile findUserProfile(Integer userId) {
        return null;
    }
}
