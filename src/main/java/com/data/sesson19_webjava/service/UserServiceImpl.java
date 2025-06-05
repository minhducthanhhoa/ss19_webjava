package com.data.sesson19_webjava.service;

import com.data.sesson19_webjava.entity.User;
import com.data.sesson19_webjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers(int page, int size) {
        return userRepository.findAll(page, size);
    }

    @Override
    public long countUsers() {
        return userRepository.count();
    }

    @Override
    public void toggleActive(Long userId) {
        User user = userRepository.findById(userId);
        if (user != null) {
            Boolean currentStatus = user.getIsActive();
            user.setIsActive(currentStatus == null ? true : !currentStatus);
            userRepository.update(user);
        }
    }
}
