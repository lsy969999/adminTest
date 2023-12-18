package com.example.admin.constant;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RVO<T>{
  @Builder.Default
  private String message = Message.Success;
  @Builder.Default
  private String errCode = Code.Success;
  @Builder.Default
  private Long timestamp = (new Date()).getTime();
  private T data;
}
