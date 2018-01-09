package com.example.service;

import com.example.entity.Users;
import com.example.exception.UserNotFoundException;

public interface UserService {
    Users getUserById(int id) throws UserNotFoundException;
}
