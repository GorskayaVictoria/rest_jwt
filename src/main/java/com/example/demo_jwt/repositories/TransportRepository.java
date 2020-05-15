package com.example.demo_jwt.repositories;

import com.example.demo_jwt.models.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransportRepository extends JpaRepository<Transport, Long> {
    List<Transport> findAllByNameContainsIgnoreCase(String name);

}