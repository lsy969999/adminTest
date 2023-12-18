package com.example.admin.mvc.auth.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.admin.mvc.auth.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>, AccountRepositoryCustom{
  
}
