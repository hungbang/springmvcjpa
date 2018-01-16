package com.example.service;

import com.example.entity.Users;
import com.example.exception.ConfirmationException;
import com.example.exception.TokenInvalidException;
import com.example.exception.UserNotFoundException;
import com.example.exception.UsernameExistException;

public interface JwtTokenService {
    String getToken(Users user);

    String verifyToken(String token) throws TokenInvalidException, UserNotFoundException, UsernameExistException, ConfirmationException;
}
