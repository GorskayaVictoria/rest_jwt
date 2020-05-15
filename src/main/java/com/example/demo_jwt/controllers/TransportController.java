package com.example.demo_jwt.controllers;

import com.example.demo_jwt.dto.TransportDto;
import com.example.demo_jwt.dto.UserDto;
import com.example.demo_jwt.models.Transport;
import com.example.demo_jwt.service.TransportService;
import com.example.demo_jwt.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;




import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@RestController
public class TransportController {

    @Autowired
    private TransportService transportService;

    @Autowired
    private UsersService userService;


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/transports")
    public ResponseEntity<List<TransportDto>> getTransportsPage(){
        return  ResponseEntity.ok(transportService.getTransports());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/transport")
    public ResponseEntity<TransportDto> getTransportsPage(@RequestParam(value = "id", required =false)Long id) {
        TransportDto transport = transportService.getConcreteTransport(id);
        return ResponseEntity.ok(transport);

    }
}

