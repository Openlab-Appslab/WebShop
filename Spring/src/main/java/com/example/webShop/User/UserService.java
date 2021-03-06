package com.example.webShop.User;

import java.util.Optional;

public interface UserService {
   User addUser(User user);
    Optional<User> getUserByUsername(String username);
    User updateUser(User user);
}
