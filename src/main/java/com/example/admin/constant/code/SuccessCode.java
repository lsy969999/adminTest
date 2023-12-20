package com.example.admin.constant.code;

public enum SuccessCode {
  S_0000("0000", "성공");

  public String code;
  public String message;

  SuccessCode(String code, String message){
    this.code = code;
    this.message = message;
  }
}