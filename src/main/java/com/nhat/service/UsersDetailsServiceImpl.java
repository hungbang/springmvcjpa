package com.nhat.service;

import com.nhat.entity.CustomerUsersDetails;
import com.nhat.entity.UsersEntity;
import com.nhat.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UsersDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity usersEntity=usersRepository.findByUsername(username);
        if(usersEntity==null){
            throw new UsernameNotFoundException("user not found");
        }
        List<GrantedAuthority> grantedAuthorities= new ArrayList<GrantedAuthority>();
        SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority("Admin");
        grantedAuthorities.add(simpleGrantedAuthority);
        CustomerUsersDetails customerUsersDetails=new CustomerUsersDetails(usersEntity.getUsername(),usersEntity.getPassword(),grantedAuthorities);
        return customerUsersDetails;
    }
}
