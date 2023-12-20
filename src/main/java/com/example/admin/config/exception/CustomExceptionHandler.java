package com.example.admin.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.admin.constant.RVO;
import com.example.admin.constant.code.ErrorCode;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ CustomException.class })
    @ResponseBody
    public ResponseEntity<RVO<Object>> handleAuthenticationException(Exception ex) {
        CustomException ce = (CustomException) ex;
        String errCode = ce.getErrCode();
        String message = ce.getMessage();
        RVO<Object> rvo = RVO.<Object>builder()
                        .errCode(errCode)
                        .message(message)
                        .data(null)
                        .build();
        log.error("handleAuthenticationException, msg: {}, errcode: {}", errCode, message);
        return ResponseEntity.status(HttpStatus.NOT_EXTENDED).body(rvo);
    }

    @ExceptionHandler({InsufficientAuthenticationException.class})
    @ResponseBody
    public ResponseEntity<RVO<Object>> handlerInsufficientAuthenticationException(Exception ex){
        String message = ex.getMessage();
        log.error("handlerInsufficientAuthenticationException, msg: {}", message);
        RVO<Object> rvo = RVO.<Object>builder()
                            .errCode(ErrorCode.E_1000.code)
                            .message(ErrorCode.E_1000.message)
                            .data(null)
                            .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(rvo);
    }
}