package com.example.back.service;

import org.springframework.http.ResponseEntity;

import com.example.back.dto.requset.warehouse.PostWarehouseCreateRequestDto;
import com.example.back.dto.requset.warehouse.PutWarehouseRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.warehouse.GetWarehouseListResponseDto;
import com.example.back.dto.response.warehouse.GetWarehouseResponseDto;

public interface WarehouseService {
    
    ResponseEntity<ResponseDto> delete(int warehouseNo);
    ResponseEntity<ResponseDto> create(PostWarehouseCreateRequestDto dto);
    ResponseEntity<ResponseDto> put(PutWarehouseRequestDto dto, int warehouseNo);

    ResponseEntity<? super GetWarehouseListResponseDto> getList();
    ResponseEntity<? super GetWarehouseResponseDto> getWarehouse(int warehouseNo);
}
