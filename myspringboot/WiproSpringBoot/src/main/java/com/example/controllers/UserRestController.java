package com.example.controllers;

import com.example.Beanfiles.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forms")  
public class UserRestController {

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        System.out.println("User: " + user.getFirstName()+user.getFirstName()+user.getAge());
        return "User created!";
    }
}
