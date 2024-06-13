package com.example.demoFirstProject.service.impl;

import com.example.demoFirstProject.model.User;
import com.example.demoFirstProject.repository.UserRepository;
import com.example.demoFirstProject.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;

     //IOC -Spring bean life cycle ,DI injection

    //DI - Dependency Injection : setter injection, constructor injection , field dependency injection

    @Override
    public User createUser(User user) {
        User saveUser = userRepository.save(user);

        return saveUser;
    }

    @Override
    public User updateUser(User user, Long userId) {
        return null;
    }

    @Override
    public User getSingleUser(Long userId) {

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
