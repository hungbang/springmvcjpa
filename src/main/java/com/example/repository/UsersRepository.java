package com.example.repository;

import com.example.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String>{
    Users findUsersByName(String name);
    Users findByEmail(String email);
}
