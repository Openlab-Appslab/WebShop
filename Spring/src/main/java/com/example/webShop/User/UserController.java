package com.example.webShop.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/user")
    public void getUser() {

    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody User user){
        userService.addUser(user);
    }

}
