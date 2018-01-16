package com.example.service;

import com.example.entity.Users;
import com.example.exception.ConfirmationException;
import com.example.exception.TokenInvalidException;
import com.example.exception.UserNotFoundException;
import com.example.exception.UsernameExistException;
import com.example.model.RegisterTemp;
import com.example.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JwtTokenService jwtTokenService;


    @Override
    public Users getUserById(String id) throws UserNotFoundException {
        if(usersRepository.findOne(id) == null)
            throw new UserNotFoundException("User does not exists.");
       return usersRepository.findOne(id);
    }

    @Override
    public void updateUser(Users curUser) throws UsernameExistException {
        Users user = usersRepository.findByEmail(curUser.getEmail());
        user.setAccessToken(curUser.getAccessToken());
        usersRepository.save(user);
    }

    @Override
    public void register(Users user) {
        saveUser(user);
        emailService.sendMailConfirmation(user);
    }

    @Override
    public void confirmRegistration(String token) throws UserNotFoundException, TokenInvalidException, UsernameExistException, ConfirmationException {
        String userId = jwtTokenService.verifyToken(token);
        Users user = getUserById(userId);
        if(user == null) {
            throw new TokenInvalidException("Token Invalid");
        }
        user.setAccessToken(Base64.getEncoder().encode(token.getBytes()));
        updateUser(user);
    }

    @Override
    public void saveUser(Users curUser) {
        curUser.setPassword(encoder.encode(curUser.getPassword()));
        usersRepository.save(curUser);
    }


}
