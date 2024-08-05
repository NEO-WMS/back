package com.example.back.service;

import com.example.back.dto.response.ResponseDto;
import com.example.back.entity.WarehouseDetailEntity;
import java.util.List;

import org.springframework.http.ResponseEntity;

public interface WarehouseDetailService {

    ResponseEntity<ResponseDto> create(PostWarehouse)

    List<WarehouseDetailEntity> findAll();
    WarehouseDetailEntity save(WarehouseDetailEntity entity);
}
