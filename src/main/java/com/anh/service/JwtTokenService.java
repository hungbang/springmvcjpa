package com.anh.service;


import com.anh.entity.UsersEntity;
import com.anh.exception.TokenInvalidException;

public interface JwtTokenService {
    String getToken(UsersEntity users);

    String verifyToken(String token) throws TokenInvalidException;
}
