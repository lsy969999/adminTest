package com.example.admin.constant;

import java.util.Date;
import com.example.admin.constant.code.SuccessCode;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RVO<T>{
  @Builder.Default
  private String message = SuccessCode.S_0000.code;
  @Builder.Default
  private String errCode = SuccessCode.S_0000.message;
  @Builder.Default
  private Long timestamp = (new Date()).getTime();
  private T data;
}
