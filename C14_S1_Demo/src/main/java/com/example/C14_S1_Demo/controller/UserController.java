package com.example.C14_S1_Demo.controller;


import com.example.C14_S1_Demo.domain.User;
import com.example.C14_S1_Demo.service.SecurityTokenGeneratorImpl;
import com.example.C14_S1_Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/userService")
public class UserController {

    UserService userService;
    SecurityTokenGeneratorImpl securityTokenGenerator;
    @Autowired
    public UserController(UserService userService,SecurityTokenGeneratorImpl securityTokenGenerator){
        this.userService=userService;
        this.securityTokenGenerator=securityTokenGenerator;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody User user){
        User result=userService.loginCheck(user.getEmailId(),user.getPassword());
        if(result!=null){
            Map<String,String> map=securityTokenGenerator.tokenGenerator(result);
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("User does not Exists",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }
}
