package com.example.back.service;

import org.springframework.http.ResponseEntity;

import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.lot.GetLotResponseDto;
import com.example.back.dto.response.lot.GetLotSearchResponseDto;

public interface LotService {
    
    ResponseEntity<? super GetLotResponseDto> getList();
    ResponseEntity<? super GetLotSearchResponseDto> search(String search);

    ResponseEntity<ResponseDto> delete (int lotNo);
}
