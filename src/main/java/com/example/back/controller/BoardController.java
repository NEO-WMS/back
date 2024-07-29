package com.example.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.dto.requset.board.PostBoardCreateRequestDto;
import com.example.back.dto.requset.board.PutBoardRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.board.GetBoardResponseDto;
import com.example.back.service.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/wms/service/board")
@RequiredArgsConstructor

public class BoardController {
    
    private final BoardService boardService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create (
        @RequestBody @Valid PostBoardCreateRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = boardService.create(requestBody);
        return response;
    }

    @GetMapping("/")
    public ResponseEntity<? super GetBoardResponseDto> getList(

    ){
        ResponseEntity<? super GetBoardResponseDto> response = boardService.getList();
        return response;
    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<ResponseDto> delete (
        @PathVariable("boardNo") int boardNo
    ) {
        ResponseEntity<ResponseDto> response = boardService.delete(boardNo);
        return response;
    }

    @PutMapping("/{boardNo}")
    public ResponseEntity<ResponseDto> put (
        @RequestBody @Valid PutBoardRequestDto requestBody,
        @PathVariable("boardNo") int boardNo
    ) {
        ResponseEntity<ResponseDto> response = boardService.put(requestBody, boardNo);
        return response;
    }
}
