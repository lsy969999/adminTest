package com.example.admin.mvc.auth.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"account"})
@SequenceGenerator(
    name = "ACCOUNT_REFRESH_TOKEN_SEQ_GENERATOR",
    sequenceName = "ACCOUNT_REFRESH_TOKEN_SEQ",
    initialValue = 1,
    allocationSize = 1
)
public class AccountRefreshToken {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "ACCOUNT_REFRESH_TOKEN_SEQ_GENERATOR"
    )
    @Column
    private Long accountRefreshTokenSn;

    @ManyToOne
    @JoinColumn
    private Account account;

    @Column
    private long hashedRefreshToken;
}
