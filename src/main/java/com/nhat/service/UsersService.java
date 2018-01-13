package com.nhat.service;

import com.nhat.entity.UsersEntity;


public interface UsersService {
    UsersEntity getUserById(int id);
    public void save(UsersEntity usersEntity);
    Iterable<UsersEntity> findAll();
    UsersEntity getUserByEmail(String email);
    int setAcctiveForUser(String email);
}