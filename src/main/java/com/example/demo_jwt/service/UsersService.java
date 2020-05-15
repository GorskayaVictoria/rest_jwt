package com.example.demo_jwt.service;



import com.example.demo_jwt.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();

    void deleteUser(Long userId);
}
