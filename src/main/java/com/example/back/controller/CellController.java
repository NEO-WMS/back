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

import com.example.back.dto.requset.cell.PostCellCreateRequestDto;
import com.example.back.dto.requset.cell.PutCellRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.cell.GetCellListResponseDto;
import com.example.back.dto.response.cell.GetCellResponseDto;
import com.example.back.service.CellService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/wms/service/cell")
@RequiredArgsConstructor

public class CellController {
    
    private final CellService cellService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create( 
        @RequestBody @Valid PostCellCreateRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = cellService.create(requestBody);
        return response;
    }

    @GetMapping("/")
    public ResponseEntity<? super GetCellListResponseDto> getList(

    ) {
        ResponseEntity<? super GetCellListResponseDto> response = cellService.getList();
        return response;
    }

    @DeleteMapping("/{cellNo}")
    public ResponseEntity<ResponseDto> delete (
        @PathVariable("cellNo") int cellNo
    ) {
        ResponseEntity<ResponseDto> response = cellService.delete(cellNo);
        return response;
    }

    @PutMapping("/{cellNo}")
    public ResponseEntity<ResponseDto> put(
        @RequestBody @Valid PutCellRequestDto requestBody,
        @PathVariable("cellNo") int cellNo
    ) {
        ResponseEntity<ResponseDto> response = cellService.put(requestBody, cellNo);
        return response;
    }

    @GetMapping("/{cellNo}")
    public ResponseEntity<? super GetCellResponseDto> getCell(
        @PathVariable("cellNo") int cellNo
    ) {
        ResponseEntity<? super GetCellResponseDto> response = cellService.getCell(cellNo);
        return response;
    }


}
