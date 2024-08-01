package com.example.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.dto.requset.member.PostMemberCreateRequestDto;
import com.example.back.dto.requset.member.PutMemberRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.member.GetMemberListResponseDto;
import com.example.back.dto.response.member.GetmemberSearchResponseDto;
import com.example.back.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("wms/service/member")
@RequiredArgsConstructor

public class MemberController {
    
    private final MemberService memberService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create (
        @RequestBody @Valid PostMemberCreateRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = memberService.create(requestBody);
        return response;
    }
    
    @GetMapping("/")
    public ResponseEntity<? super GetMemberListResponseDto> getList() {
        ResponseEntity<? super GetMemberListResponseDto> response = memberService.getList();
        return response;
    }

    @DeleteMapping("/{memberNo}")
    public ResponseEntity<ResponseDto> delete (
        @PathVariable("memberNo") int memberNo
    ) {
        ResponseEntity<ResponseDto> response = memberService.delete(memberNo);
        return response;
    }
    
    @PutMapping("/{memberNo}")
    public ResponseEntity<ResponseDto> put (
        @RequestBody @Valid PutMemberRequestDto requestBody,
        @PathVariable("memberNo") int memberNo
    ) {
        ResponseEntity<ResponseDto> response = memberService.put(requestBody, memberNo);
        return response;
    }

    @GetMapping("/search")
    public ResponseEntity<? super GetmemberSearchResponseDto> search (
        @RequestParam("search") String search
    ) {
        ResponseEntity<? super GetmemberSearchResponseDto> response = memberService.search(search);
        return response;
    }
}
