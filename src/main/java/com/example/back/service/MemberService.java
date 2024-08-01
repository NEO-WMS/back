package com.example.back.service;

import org.springframework.http.ResponseEntity;

import com.example.back.dto.requset.member.PostMemberCreateRequestDto;
import com.example.back.dto.requset.member.PutMemberRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.member.GetMemberListResponseDto;
import com.example.back.dto.response.member.GetmemberSearchResponseDto;

public interface MemberService {
    
    ResponseEntity<ResponseDto> delete(int memberNo);
    ResponseEntity<ResponseDto> create(PostMemberCreateRequestDto dto);
    ResponseEntity<ResponseDto> put(PutMemberRequestDto dto, int memberNo);

    ResponseEntity<? super GetMemberListResponseDto> getList();
    ResponseEntity<? super GetmemberSearchResponseDto> search(String search);
    
}
