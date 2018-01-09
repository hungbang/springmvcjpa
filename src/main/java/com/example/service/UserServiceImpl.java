package com.example.service;

import com.example.entity.Users;
import com.example.exception.UserNotFoundException;
import com.example.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public Users getUserById(int id) throws UserNotFoundException {
        if(usersRepository.findOne(id) == null)
            throw new UserNotFoundException("User does not exists.");
       return usersRepository.findOne(id);
    }
}
