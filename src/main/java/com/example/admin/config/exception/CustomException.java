package com.example.admin.config.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
  private String errCode;

  public CustomException(String message) {
    super(message);
  }

  public CustomException(String errCode, String message){
    super(message);
    this.errCode = errCode;
  }
}
