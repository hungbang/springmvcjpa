package com.anh.service;

import com.anh.entity.UsersEntity;
import com.anh.model.CurrentUser;
import com.anh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity usersEntity = userRepository.findByEmail(username);
        if(usersEntity == null){
            throw new UsernameNotFoundException("User does not exist");
        }
        return new CurrentUser(usersEntity);
    }
}
