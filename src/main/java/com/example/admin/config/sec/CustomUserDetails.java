package com.example.admin.config.sec;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.Data;

@Data
public class CustomUserDetails implements UserDetails {
  private long userSn;
  private String email;
  private String password;
  private String name;
  private Collection<GrantedAuthority> authorities;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
  
}
