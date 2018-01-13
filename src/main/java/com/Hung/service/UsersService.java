package com.Hung.service;

import com.Hung.entity.UsersEntity;


public interface UsersService {
    UsersEntity getUserById(int id);
    public void save(UsersEntity usersEntity);
    Iterable<UsersEntity> findAll();
    UsersEntity getUserByEmail(String email);
    int setAcctiveForUser(String email);
}