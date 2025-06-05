package com.data.sesson19_webjava.service;

import com.data.sesson19_webjava.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers(int page, int size);
    long countUsers();
    void toggleActive(Long userId);
}
