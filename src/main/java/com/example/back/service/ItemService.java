package com.example.back.service;

import org.springframework.http.ResponseEntity;

import com.example.back.dto.requset.item.PostItemCreateRequestDto;
import com.example.back.dto.requset.item.PutItemRequestDto;
import com.example.back.dto.response.ResponseDto;

import com.example.back.dto.response.item.GetItemListResponseDto;
import com.example.back.dto.response.item.GetItemSearchResponseDto;

public interface ItemService {
    
    ResponseEntity<ResponseDto> delete(int itemNo);
    ResponseEntity<ResponseDto> create(PostItemCreateRequestDto dto);
    ResponseEntity<ResponseDto> put(PutItemRequestDto dto, int itemNo);

    ResponseEntity<? super GetItemListResponseDto> getList();
    ResponseEntity<? super GetItemSearchResponseDto> search(String search);

}
