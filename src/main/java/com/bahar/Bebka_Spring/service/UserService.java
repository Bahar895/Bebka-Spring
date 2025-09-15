package com.bahar.Bebka_Spring.service;

import com.bahar.Bebka_Spring.model.User;

public interface UserService {
    User getUserByUsername(String username);
    User saveUser(User user);
}