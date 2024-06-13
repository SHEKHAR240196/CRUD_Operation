package com.example.demoFirstProject.service;

import com.example.demoFirstProject.model.User;

import java.util.List;

public interface UserServiceI {

    //CURD

       // Create

      User createUser(User user);

      //Update

     User updateUser(User user,Long userId);


     //Get single

      User  getSingleUser(Long userId);

     //Get All data

      List<User> getAllUsers();

     //Delete

     void deleteUser(Long userId);
}
