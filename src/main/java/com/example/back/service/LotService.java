package com.example.back.service;

import org.springframework.http.ResponseEntity;

import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.lot.GetLotListResponseDto;
import com.example.back.dto.response.lot.GetLotSearchResponseDto;

public interface LotService {
    
    ResponseEntity<? super GetLotListResponseDto> getList();
    ResponseEntity<? super GetLotSearchResponseDto> search(String search);

    ResponseEntity<ResponseDto> delete (int lotNo);
}
