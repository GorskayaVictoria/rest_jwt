package com.example.demo_jwt.dto;

import lombok.Data;

@Data
public class SignInDto {
    private String email;
    private String password;
}
