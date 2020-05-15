package com.example.demo_jwt.service;


import com.example.demo_jwt.dto.TransportDto;
import com.example.demo_jwt.models.Transport;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

public interface TransportService {
    List<TransportDto> getTransports();
    TransportDto getConcreteTransport(Long transportId);
    List<TransportDto> search(String name);




}
