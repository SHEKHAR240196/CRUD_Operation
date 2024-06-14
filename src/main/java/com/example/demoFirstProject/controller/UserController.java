package com.example.demoFirstProject.controller;

import com.example.demoFirstProject.model.User;
import com.example.demoFirstProject.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

    @PostMapping("/")
    public ResponseEntity<User> createUser(){

        return null;
    }


}
