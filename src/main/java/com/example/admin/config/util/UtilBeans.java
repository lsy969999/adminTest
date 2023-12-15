package com.example.admin.config.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class UtilBeans {
  @Bean
  public ObjectMapper objectMapper(){
    return new ObjectMapper();
  }
}
