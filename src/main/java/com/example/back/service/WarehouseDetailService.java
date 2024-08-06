package com.example.back.service;

import com.example.back.dto.requset.warehouse.PostWarehouseCreateRequestDto;
import com.example.back.dto.response.ResponseDto;

import org.springframework.http.ResponseEntity;

public interface WarehouseDetailService {

    ResponseEntity<ResponseDto> create(PostWarehouseCreateRequestDto dto);
    

}
