package com.example.service;

import com.example.entity.Users;
import com.example.exception.ConfirmationException;
import com.example.exception.TokenInvalidException;
import com.example.exception.UserNotFoundException;
import com.example.exception.UsernameExistException;
import com.example.model.RegisterTemp;

public interface UserService {
    Users getUserById(String id) throws UserNotFoundException;
    void updateUser(Users user) throws UsernameExistException;
    void register(Users user) throws UsernameExistException, ConfirmationException;
    void confirmRegistration(String token) throws UserNotFoundException, TokenInvalidException, UsernameExistException, ConfirmationException;
    void saveUser(Users user) throws UsernameExistException, ConfirmationException;
}
