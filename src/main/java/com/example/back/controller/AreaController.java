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

import com.example.back.dto.requset.area.PostAreaCreateRequestDto;
import com.example.back.dto.requset.area.PutAreaRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.area.GetAreaListResponseDto;
import com.example.back.dto.response.area.GetAreaResponseDto;
import com.example.back.service.AreaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/wms/service/area")
@RequiredArgsConstructor

public class AreaController {

    private final AreaService areaService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create(
        @RequestBody @Valid PostAreaCreateRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = areaService.create(requestBody);
        return response;
    }

    @GetMapping("/")
    public ResponseEntity<? super GetAreaListResponseDto> getList(

    ) {
        ResponseEntity<? super GetAreaListResponseDto> response = areaService.getList();
        return response;
    }

    @DeleteMapping("/{areaNo}")
    public ResponseEntity<ResponseDto> delete (
        @PathVariable("areaNo") int areaNo
    ) {
        ResponseEntity<ResponseDto> response = areaService.delete(areaNo);
        return response;
    }

    @PutMapping("/{areaNo}")
    public ResponseEntity<ResponseDto> put (
        @RequestBody @Valid PutAreaRequestDto requestBody,
        @PathVariable("areaNo") int areaNo
    ) {
        ResponseEntity<ResponseDto> response = areaService.put(requestBody, areaNo);
        return response;
    }

    @GetMapping("/{areaNo}")
    public ResponseEntity<? super GetAreaResponseDto> getArea(
        @PathVariable("areaNo") int areaNo
    ) {
        ResponseEntity<? super GetAreaResponseDto> response = areaService.getArea(areaNo);
        return response;
    }
    
}
