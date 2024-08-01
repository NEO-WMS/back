package com.example.back.service;

import org.springframework.http.ResponseEntity;

import com.example.back.dto.requset.board.PostBoardCreateRequestDto;
import com.example.back.dto.requset.board.PutBoardRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.board.GetBoardListResponseDto;
import com.example.back.dto.response.board.GetBoardResponseDto;

public interface BoardService {

    ResponseEntity<ResponseDto> delete(int boardNo);
    ResponseEntity<ResponseDto> create(PostBoardCreateRequestDto dto);
    ResponseEntity<ResponseDto> put(PutBoardRequestDto dto, int boardNo);
    
    ResponseEntity<? super GetBoardListResponseDto> getList();
    ResponseEntity<? super GetBoardResponseDto> getBoard(int boardNo);
}
