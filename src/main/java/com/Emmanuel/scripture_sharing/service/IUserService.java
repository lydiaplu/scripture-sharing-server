package com.Emmanuel.scripture_sharing.service;

import com.Emmanuel.scripture_sharing.model.User;

public interface IUserService {
    public User addUser(String email, String username, String provider);

    public void deleteUserById(Integer id);

    public User findUserById(Integer id);
}
