package com.example.repository;

import com.example.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UsersRepository extends JpaRepository<Users, Integer>{
    @Transactional(readOnly = true)
    public Users findByEmail(String email);
}
