package com.example.back.service;

import org.springframework.http.ResponseEntity;

import com.example.back.dto.requset.cell.PostCellCreateRequestDto;
import com.example.back.dto.requset.cell.PutCellRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.cell.GetCellListResponseDto;
import com.example.back.dto.response.cell.GetCellResponseDto;

public interface CellService {

    ResponseEntity<ResponseDto> delete(int cellNo);
    ResponseEntity<ResponseDto> create(PostCellCreateRequestDto dto);
    ResponseEntity<ResponseDto> put(PutCellRequestDto dto, int cellNo);

    ResponseEntity<? super GetCellListResponseDto> getList();
    ResponseEntity<? super GetCellResponseDto> getCell(int cellNo);
    
}
