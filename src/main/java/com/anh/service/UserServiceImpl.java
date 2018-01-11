package com.anh.service;

import com.anh.entity.UsersEntity;
import com.anh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveCustomer(UsersEntity user) {
        userRepository.save(user);
    }
}
