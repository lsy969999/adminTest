package com.example.admin.mvc.auth.service;

import org.springframework.stereotype.Service;
import com.example.admin.component.JwtComponent;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final JwtComponent jwtComponent;
  
  private String generateAccessToken(){
    long exp = 1000 * 60 * 60 * 3;
    return null;
  }

  private String generateRefreshToken(){
    long exp = 1000 * 60 * 60 * 3;
    return null;
  }
}
