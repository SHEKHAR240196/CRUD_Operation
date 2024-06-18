package com.example.demoFirstProject.controller;

import com.example.demoFirstProject.model.User;
import com.example.demoFirstProject.service.UserServiceI;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    //Logger-Log4j
    //Slf4j
    //INFO,WARN,DEBUG,ERROR,TRACE

    Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceI userServiceI;

    //UI to Controller Layer send the data:
    //@PathVariable - pass single data            - / , /
    //@RequestBody  - whole object - secure
   // @RequestParam - key ,value pair pass data   -? , &


   // @RequestMapping(method = RequestMethod.POST ,name = "/users")
   @PostMapping("/users")
   public ResponseEntity<User> createUser(@RequestBody User user) {

       logger.info("Entering the request for save user data");
        User saveUser = userServiceI.createUser(user);
       logger.info("Completed the request for save user data");
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED); //201:Status Code
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userServiceI.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK); //200 :Status Code
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId){

       logger.info("Entering the request for get user data with userId {} " ,userId);
        User user = userServiceI.getSingleUser(userId);
        logger.info("Completed the request for get user data with userId {} " ,userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId){
        User updateUser = userServiceI.updateUser(user, userId);
        return new ResponseEntity<>(updateUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        userServiceI.deleteUser(userId);
        return new ResponseEntity<>("Resource delete Successful !!", HttpStatus.OK);
    }
}
