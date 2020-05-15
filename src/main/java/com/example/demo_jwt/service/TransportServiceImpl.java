package com.example.demo_jwt.service;


import com.example.demo_jwt.dto.TransportDto;
import com.example.demo_jwt.models.Transport;
import com.example.demo_jwt.repositories.TransportRepository;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.demo_jwt.dto.TransportDto.from;


@Service
public class TransportServiceImpl implements TransportService {

    @Autowired
    private TransportRepository transportsRepository;

    @Override
    public List<TransportDto> getTransports() {
        return from(transportsRepository.findAll());
    }


    @Override
    public TransportDto getConcreteTransport(Long transportId) {
        Transport transport = transportsRepository.getOne(transportId);
        return from(transport);
    }

    @Override
    public List<TransportDto> search(String name) {
        return from(transportsRepository.findAllByNameContainsIgnoreCase(name));
    }




}
