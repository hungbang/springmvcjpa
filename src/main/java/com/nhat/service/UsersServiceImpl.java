package com.nhat.service;

import com.nhat.entity.UsersEntity;
import com.nhat.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UsersEntity getUserById(int id) {
        return usersRepository.findOne(id);
    }

    @Override
    public void save(UsersEntity usersEntity) {
        usersEntity.setPassword(passwordEncoder.encode(usersEntity.getPassword()));
        usersRepository.save(usersEntity);
    }

    @Override
    public Iterable<UsersEntity> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public UsersEntity getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public int setAcctiveForUser(String email) {
        return usersRepository.setActiveUser(email);
    }


}
