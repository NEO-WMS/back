package com.example.back.service;

import org.springframework.http.ResponseEntity;

import com.example.back.dto.requset.rack.PostRackCreateRequestDto;
import com.example.back.dto.requset.rack.PutRackRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.rack.GetRackListResponseDto;
import com.example.back.dto.response.rack.GetRackResponseDto;

public interface RackService {

    ResponseEntity<ResponseDto> delete(int rackNo);
    ResponseEntity<ResponseDto> create(PostRackCreateRequestDto dto);
    ResponseEntity<ResponseDto> put(PutRackRequestDto dto, int rackNo);

    ResponseEntity<? super GetRackListResponseDto> getList();
    ResponseEntity<? super GetRackResponseDto> getRack(int rackNo);
    
}
