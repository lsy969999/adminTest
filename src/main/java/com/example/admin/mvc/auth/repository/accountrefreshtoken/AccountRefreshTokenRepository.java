package com.example.admin.mvc.auth.repository.accountrefreshtoken;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.admin.mvc.auth.entity.AccountRefreshToken;

@Repository
public interface AccountRefreshTokenRepository extends JpaRepository<AccountRefreshToken, Long>, AccountRefreshTokenRepositoryCustom{
  
}
