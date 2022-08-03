package com.project.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.auth.entity.User;

@Repository
public interface AuthRepository extends JpaRepository<User,Integer> 
{
             public User findByUsername(String username);
}
