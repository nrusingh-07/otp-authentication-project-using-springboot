package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.entities.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
public User findByUsername(String username);
}  
  


