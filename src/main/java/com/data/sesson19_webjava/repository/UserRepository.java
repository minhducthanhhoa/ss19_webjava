package com.data.sesson19_webjava.repository;

import com.data.sesson19_webjava.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll(int page, int size);
    long count();
    User findById(Long id);
    void update(User user);
}
