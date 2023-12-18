package com.example.admin.config.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
  private final JwtFilter jwtFilter;
  private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
  private final CustomAccessDeniedHandler customAccessDeniedHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
              .csrf(csrf->csrf.disable())
              .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
              .authorizeHttpRequests(
                      authorize -> authorize
                              // .requestMatchers("/api/sample/**").permitAll()
                              .requestMatchers("/sample/**").permitAll()
                              .requestMatchers("/public/**").permitAll()
                              .requestMatchers("/static/**").permitAll()
                              .requestMatchers("/docs/**").permitAll()
                              .requestMatchers("/api/auth/email").permitAll()
                              .anyRequest().authenticated()
              )
              .exceptionHandling(eh -> {
                eh.authenticationEntryPoint(this.customAuthenticationEntryPoint);
                eh.accessDeniedHandler(customAccessDeniedHandler);
              })
              .httpBasic(b->b.disable())
              .formLogin(f->f.disable())
              .sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
              .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
              .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
}
