package com.GeT.commerce.controllers;

import com.GeT.commerce.entity.User;
import com.GeT.commerce.exceptions.ProductNotFoundException;
import com.GeT.commerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @CrossOrigin
    @PutMapping
    public void registerNewUserAccount(@RequestBody User user){
        userService.registerNewUserAccount(user);
    }
}
