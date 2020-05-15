package com.example.demo_jwt.service;


import com.example.demo_jwt.dto.SignInDto;
import com.example.demo_jwt.dto.TokenDto;

public interface SignInService {
    TokenDto signIn(SignInDto signInData);
}
