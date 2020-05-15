package com.example.demo_jwt.controllers;

import com.example.demo_jwt.dto.UserDto;
import com.example.demo_jwt.security.jwt.details.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProfileController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/self")
    public ResponseEntity<UserDto> getSelf() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getDetails();
        System.out.println(userDetails);
        return ResponseEntity.ok(UserDto.builder()
                .name(userDetails.getUsername())
                .id(userDetails.getUserId())
                .email(userDetails.getEmail())
                .build());
    }
}
