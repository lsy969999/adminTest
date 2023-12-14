package com.example.admin.component;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class JwtComponentTest {
  @Autowired
  private JwtComponent jwtComponent;

  @Test
  void createJwtTest(){
    log.error("createJwtTest123123123");
  }

  @Test
  void readJwtTest(){
    log.info("createJwtTest123123123");

  }


}
