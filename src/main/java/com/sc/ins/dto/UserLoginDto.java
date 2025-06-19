package com.sc.ins.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto
{
    private Long userId;

    private Timestamp timestamp;

    private String status;
}
