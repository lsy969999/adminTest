package com.example.admin.component;

import java.util.HashMap;
import java.util.Map;
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
    Map<String, Object> claims = new HashMap<>();
    claims.put("test1", "test1val");
    claims.put("test2", "test2val");
    long exp = 1000 * 60 * 60; //1hour
    String jwt = jwtComponent.createJwt(claims, exp);
    log.info("jwt: {}", jwt);
  }

  @Test
  void readJwtTest(){
    // String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJ0ZXN0MiI6InRlc3QydmFsIiwidGVzdDEiOiJ0ZXN0MXZhbCJ9.Si2p5sftpWbfa0YPJKwa-59RQv6S_lpg5ib_5FfL4Kc";
    String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJ0ZXN0MiI6InRlc3QydmFsIiwidGVzdDEiOiJ0ZXN0MXZhbCIsImlhdCI6MTcwMjg2NzE0OCwiZXhwIjoxNzAyODY3MTQ5fQ.3AbZilEupNGmCA3DU58x3qUigKiad0ouzN0Fm0iQtlQ";
    Map<String, Object> payloadMap = this.jwtComponent.getJwtPayload(jwt);
    log.info("payloadMap: {}", payloadMap);
  }
}
