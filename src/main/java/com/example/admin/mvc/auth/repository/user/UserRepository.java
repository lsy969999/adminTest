package com.example.admin.mvc.auth.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.admin.mvc.auth.entity.User;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom{
  
}
