package com.example.admin.mvc.auth.dto;

import lombok.Getter;

@Getter
public class UserAddDTO {
  private String email;
  private String password;
  private String name;
  private String nickName;
}
