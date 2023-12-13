package com.example.admin.mvc.auth.entity;

import java.time.LocalDateTime;

public class Account {
    private Long accountSn;
    private String email;

    private User user;

    private Provider provider;
    private String providerId;
    private AccountStatus accountStatus;

    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}