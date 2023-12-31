package com.example.admin.component;

import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtComponent {
  private final ObjectMapper om;
  @Value("${app.jwt.secret}")
  private String jwtSecret;

  private SecretKey getJwtKey(){
    byte[] keyBytes = Decoders.BASE64.decode(this.jwtSecret);
    return Keys.hmacShaKeyFor(keyBytes);
  }
  
  public String createJwt(Map<String, ?> claims, long exp){
    Date expDate = new Date();
    expDate.setTime(expDate.getTime() + exp);
    String jwt = Jwts.builder()
                      .claims(claims)
                      .signWith(this.getJwtKey())
                      .issuedAt(new Date())
                      .expiration(expDate)
                      .compact();
    return jwt;
  }

  public Map<String, Object> getJwtPayload(String jwtStr) throws MalformedJwtException, SecurityException, ExpiredJwtException, IllegalArgumentException  {
    Jwt<?, ?> jwt = Jwts.parser()
                .verifyWith(this.getJwtKey())
                .build()
                .parse(new StringBuffer(jwtStr));

    Object rawPaylaod = jwt.getPayload();
    Map<String, Object> payloadMap = om.convertValue(rawPaylaod, new TypeReference<Map<String, Object>>() {});
    return payloadMap;
  }
}
