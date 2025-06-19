package com.sc.ins.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users_logins")
public class UserLogin
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notification_id;

    private Long userId;

    private String type;

    private LocalDateTime timestamp;

    private String status;
}
