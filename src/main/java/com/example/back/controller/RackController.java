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

import com.example.back.dto.requset.rack.PostRackCreateRequestDto;
import com.example.back.dto.requset.rack.PutRackRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.rack.GetRackListResponseDto;
import com.example.back.dto.response.rack.GetRackResponseDto;
import com.example.back.service.RackService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/wms/service/rack")
@RequiredArgsConstructor

public class RackController {

    private final RackService rackService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create(
        @RequestBody @Valid PostRackCreateRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = rackService.create(requestBody);
        return response;
    }

    @GetMapping("/")
    public ResponseEntity<? super GetRackListResponseDto> getList(

    ) {
        ResponseEntity<? super GetRackListResponseDto> response = rackService.getList();
        return response;
    }

    @DeleteMapping("/{rackNo}")
    public ResponseEntity<ResponseDto> delete(
        @PathVariable("rackNo") int rackNo
    ) {
        ResponseEntity<ResponseDto> response = rackService.delete(rackNo);
        return response;
    }

    @PutMapping("/{rackNo}")
    public ResponseEntity<ResponseDto> put(
        @RequestBody @Valid PutRackRequestDto requestBody,
        @PathVariable("rackNo") int rackNo
    ) {
        ResponseEntity<ResponseDto> response = rackService.put(requestBody, rackNo);
        return response;
    }

    @GetMapping("/{rackNo}")
    public ResponseEntity<? super GetRackResponseDto> getRack (
        @PathVariable("rackNo") int rankNo
    ) {
        ResponseEntity<? super GetRackResponseDto> response = rackService.getRack(rankNo);
        return response;
    }
    
}
