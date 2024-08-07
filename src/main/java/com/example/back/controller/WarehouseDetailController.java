package com.example.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.dto.requset.warehouseDetail.PostWarehouseDetailCreateRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.service.WarehouseDetailService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/wms/service/warehouseDetail")
@RequiredArgsConstructor

public class WarehouseDetailController {

    private final WarehouseDetailService warehouseDetailService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create (
        @RequestBody @Valid PostWarehouseDetailCreateRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = warehouseDetailService.create(requestBody);
        return response;
    }


}
