package com.example.back.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.lot.GetLotListResponseDto;
import com.example.back.dto.response.lot.GetLotSearchResponseDto;
import com.example.back.service.LotService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/wms/service/lot")
@RequiredArgsConstructor

public class LotController {
    
    private final LotService lotService;

    @GetMapping("/")
    public ResponseEntity<? super GetLotListResponseDto> getList(

    ) {
        ResponseEntity<? super GetLotListResponseDto> response = lotService.getList();
        return response;
    }

    @DeleteMapping("/{lotNo}")
    public ResponseEntity<ResponseDto> delete (
        @PathVariable("lotNo") int lotNo
    ) {
        ResponseEntity<ResponseDto> response = lotService.delete(lotNo);
        return response;
    }

    @GetMapping("/search")
    public ResponseEntity<? super GetLotSearchResponseDto> search(
        @RequestParam("search") String search
    ) {
        ResponseEntity<? super GetLotSearchResponseDto> response = lotService.search(search);
        return response;
    }

}
