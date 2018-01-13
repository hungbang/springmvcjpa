package com.Hung.repository;

import com.Hung.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity,Integer> {

    UsersEntity findByUsername(String username);
    UsersEntity findByEmail(String email);

    @Modifying
    @Query("UPDATE UsersEntity c SET c.active=true WHERE c.email=:email")
    int setActiveUser(@Param("email") String email);



}
