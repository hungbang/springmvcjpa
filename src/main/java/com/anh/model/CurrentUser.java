package com.anh.model;

import com.anh.entity.UsersEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {
    private UsersEntity user;

    public CurrentUser(UsersEntity user) {
        super(user.getEmail(), user.getPassword(), null);
        this.user = user;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }
}
