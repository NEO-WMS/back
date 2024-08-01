package com.example.back.service;

import org.springframework.http.ResponseEntity;

import com.example.back.dto.requset.rank.PostRankCreateRequestDto;
import com.example.back.dto.requset.rank.PutRankRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.rank.GetRankListResponseDto;
import com.example.back.dto.response.rank.GetRankSearchResponseDto;

public interface RankService {
    
    ResponseEntity<ResponseDto> delete(int rankNo);
    ResponseEntity<ResponseDto> create(PostRankCreateRequestDto dto);
    ResponseEntity<ResponseDto> put(PutRankRequestDto dto, int rankNo);

    ResponseEntity<? super GetRankListResponseDto> getList();
    ResponseEntity<? super GetRankSearchResponseDto> search(String search);  
}
