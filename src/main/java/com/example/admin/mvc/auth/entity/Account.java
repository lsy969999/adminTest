package com.example.admin.mvc.auth.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_account")
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"user"})
@SequenceGenerator(
    name = "ACCOUNT_SEQ_GENERATOR",
    sequenceName = "ACCOUNT_SEQ",
    initialValue = 1,
    allocationSize = 1
)
public class Account {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "ACCOUNT_SEQ_GENERATOR"
    )
    @Column
    private Long accountSn;

    @Column
    private String email;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn()
    private User user;

    @Column
    @Enumerated(EnumType.STRING)
    private Provider provider;

    @Column
    private String providerId;

    @Column
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @Column
    private Long createdBy;

    @LastModifiedDate
    @Column
    private LocalDateTime updatedAt;

    @Column
    private Long updatedBy;
}