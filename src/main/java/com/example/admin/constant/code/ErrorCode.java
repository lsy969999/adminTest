package com.example.admin.constant.code;

public enum ErrorCode {
  E_9999("9999", "알수 없는 에러."),
  E_1000("1000", "인증정보가 없습니다.");

  public String code;
  public String message;

  ErrorCode(String code, String message){
    this.code = code;
    this.message = message;
  }
}
