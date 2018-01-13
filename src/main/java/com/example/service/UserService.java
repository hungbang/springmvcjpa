package com.example.service;

import com.example.entity.Users;
import com.example.exception.UserNotFoundException;
import com.example.model.RegisterTemp;

public interface UserService {
    Users getUserById(int id) throws UserNotFoundException;
    void saveUser(RegisterTemp tempUser);
}
