package com.example.admin.config.sec;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return CustomUserDetails.builder()
            .name("name")
            .password("1234")
            .build();
  }
  
}
