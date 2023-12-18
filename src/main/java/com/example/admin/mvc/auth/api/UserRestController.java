package com.example.admin.mvc.auth.api;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserRestController {
  
  @PostMapping
  public void addUser(){

  }

  @PutMapping("/{userSn}")
  public void changeUser(@PathVariable("userSn") Long userSn){

  }

  @DeleteMapping("/{userSn}")
  public void deleteUser(@PathVariable("userSn") Long userSn){

  }

  @GetMapping("/{userSn}")
  public void getUserOne(@PathVariable("userSn") Long userSn){

  }

  @GetMapping
  public void getUsers(){
    
  }
}
