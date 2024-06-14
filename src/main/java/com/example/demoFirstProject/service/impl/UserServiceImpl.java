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

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Resource not found on server!!" + userId));

        return user;
    }
        /* Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()){
            return user.get();
        }else{
            throw new NullPointerException("Resource not found on server!! " + userId);
        }  */

    @Override
    public List<User> getAllUsers() {

        List<User> allUsers = userRepository.findAll();

        return allUsers;
    }

    @Override
    public void deleteUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Resource not found on server!!" + userId));

        userRepository.delete(user);

    }
}
