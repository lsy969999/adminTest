package com.example.admin.mvc.auth.repository.accountrefreshtoken;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.admin.mvc.auth.entity.AccountRefreshToken;

public interface AccountRefreshTokenRepository extends JpaRepository<AccountRefreshToken, Long>, AccountRefreshTokenRepositoryCustom{
  
}
