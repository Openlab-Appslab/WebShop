/*package com.example.webShop.User;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users")
    public List<User> getUsers() {

       return (List<User>) userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        //userRepository.save(user);
        userService.saveUser(user);
    }

    @GetMapping("/test")
    public String test(){
        return "amigos";
    }
}
*/