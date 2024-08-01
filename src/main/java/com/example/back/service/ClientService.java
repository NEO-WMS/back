package com.example.back.service;

import org.springframework.http.ResponseEntity;

import com.example.back.dto.requset.client.PostClientCreateRequestDto;
import com.example.back.dto.requset.client.PutClientRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.client.GetClientListResponseDto;
import com.example.back.dto.response.client.GetClientSearchResponseDto;

public interface ClientService {
    
    ResponseEntity<ResponseDto> delete(int clientNo);
    ResponseEntity<ResponseDto> create(PostClientCreateRequestDto dto);
    ResponseEntity<ResponseDto> put(PutClientRequestDto dto, int clientNo);

    ResponseEntity<? super GetClientListResponseDto> getList();
    ResponseEntity<? super GetClientSearchResponseDto> search(String search);
    ResponseEntity<? super GetClientListResponseDto> getListByOrderCategory(int clientCategory);
    ResponseEntity<? super GetClientListResponseDto> getListByOrderingCategory(int clientCategory);
}
