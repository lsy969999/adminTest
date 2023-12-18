package com.example.admin.mvc.auth.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.admin.mvc.auth.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>, AccountRepositoryCustom{
  
}
