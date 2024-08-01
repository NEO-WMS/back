package com.example.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.dto.requset.warehouse.PostWarehouseCreateRequestDto;
import com.example.back.dto.requset.warehouse.PutWarehouseRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.warehouse.GetWarehouseListResponseDto;
import com.example.back.dto.response.warehouse.GetWarehouseResponseDto;
import com.example.back.service.WarehouseService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/wms/service/warehouse")
@RequiredArgsConstructor

public class WarehouseController {
    
    private final WarehouseService warehouseService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create(
        @RequestBody @Valid PostWarehouseCreateRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = warehouseService.create(requestBody);
        return response;
    }

    @GetMapping("/")
    public ResponseEntity<? super GetWarehouseListResponseDto> getLitst(

    ) {
        ResponseEntity<? super GetWarehouseListResponseDto> response = warehouseService.getList();
        return response;
    }

    @DeleteMapping("/{warehouseNo}")
    public ResponseEntity<ResponseDto> delete(
        @PathVariable("warehouseNo") int warehouseNo
    ) {
        ResponseEntity<ResponseDto> response = warehouseService.delete(warehouseNo);
        return response;
    }

    @PutMapping("/{warehouseNo}")
    public ResponseEntity<ResponseDto> put (
        @RequestBody  @Valid PutWarehouseRequestDto requestBody,
        @PathVariable("warehouseNo") int warehouseNo
    ) {
        ResponseEntity<ResponseDto> response = warehouseService.put(requestBody, warehouseNo);
        return response;
    }

    @GetMapping("/{warehouseNo}")
    public ResponseEntity<? super GetWarehouseResponseDto> getWarehouse(
        @PathVariable("warehouseNo") int warehouseNo
    ) {
        ResponseEntity<? super GetWarehouseResponseDto> response = warehouseService.getWarehouse(warehouseNo);
        return response;
    }
    
}
