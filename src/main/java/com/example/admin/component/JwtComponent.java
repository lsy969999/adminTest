package com.example.admin.component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtComponent {

  private String jwtSecret = "secret";

  private SecretKey getJwtKey(){
    byte[] keyBytes = Decoders.BASE64.decode(this.jwtSecret);
    return Keys.hmacShaKeyFor(keyBytes);
  }
  
  public String createJwt(Map<String, ?> claims){
    String jwt = Jwts.builder()
                      .claims(claims)
                      .signWith(this.getJwtKey())
                      .compact();
    return jwt;
  }

  public void readingJwt(String jwtStr){
    Jwt<?, ?> jwt;
    try {
      jwt = Jwts.parser()
                .verifyWith(this.getJwtKey())
                .build()
                .parse(new StringBuffer(jwtStr));
    } catch (JwtException e) {
      log.error("readingJwt Error {}", e.getMessage());
      throw e;
    }

    log.debug("readingJwt: {}", jwt);
  }
}
