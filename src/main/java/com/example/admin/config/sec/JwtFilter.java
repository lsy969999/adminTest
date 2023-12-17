package com.example.admin.config.sec;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.Map;

import com.example.admin.component.JwtComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
  private final JwtComponent jwtComponent;
  private final CustomUserDetailsService customUserDetailsService;
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    final String authorization = request.getHeader("Authorization");
    if(authorization == null) {
      log.warn("authorization is null");
      filterChain.doFilter(request, response);
      return;
    }
    String token = authorization.split(" ")[1];
    Map<String, Object> claims = null;
    try{
     claims = jwtComponent.getJwtPayload(token);
    } catch (Exception e) {
      log.error(e.getMessage());
    }

    UserDetails cud = customUserDetailsService.loadUserByUsername("");

    Authentication authentication = new UsernamePasswordAuthenticationToken(cud, "null", cud.getAuthorities());
    SecurityContextHolder.getContext().setAuthentication(authentication);
    log.debug("JwtFilter--- authorization: {}, claims: {}", authorization, claims);
    filterChain.doFilter(request, response);
  }
}
