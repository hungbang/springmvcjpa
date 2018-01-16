package com.example.service;

import com.example.entity.Users;

public interface EmailService {
    void sendMailConfirmation(Users user);
}
