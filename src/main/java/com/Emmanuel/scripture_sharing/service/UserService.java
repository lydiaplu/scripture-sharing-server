package com.Emmanuel.scripture_sharing.service;

import com.Emmanuel.scripture_sharing.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    @Override
    public User addUser(String email, String username, String provider) {
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {

    }

    @Override
    public User findUserById(Integer id) {
        return null;
    }
}
