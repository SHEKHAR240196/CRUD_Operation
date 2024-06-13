package com.example.demoFirstProject.service.impl;

import com.example.demoFirstProject.model.User;
import com.example.demoFirstProject.repository.UserRepository;
import com.example.demoFirstProject.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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

        User user1 = userRepository.findById(userId).get();

        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user.getAbout());

        User updatedUser = userRepository.save(user1);

        return updatedUser;
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
