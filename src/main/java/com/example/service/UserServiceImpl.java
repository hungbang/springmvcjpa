package com.example.service;

import com.example.entity.Users;
import com.example.exception.UserNotFoundException;
import com.example.exception.UsernameExistException;
import com.example.model.RegisterTemp;
import com.example.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public Users getUserById(int id) throws UserNotFoundException {
        if(usersRepository.findOne(id) == null)
            throw new UserNotFoundException("User does not exists.");
       return usersRepository.findOne(id);
    }

    @Override
    public void saveUser(RegisterTemp tempUser) throws UsernameExistException {
        tempUser.setPassword(encoder.encode(tempUser.getPassword()));
        Users user = new Users(tempUser.getUsername(), tempUser.getPassword());

        Users users = usersRepository.findUsersByName(tempUser.getUsername());
        if(users != null)
            throw new UsernameExistException("User is exist.");
        user.setAccessToken("");
        user.setCreated("");
        user.setName("");
        usersRepository.save(user);
    }
}
