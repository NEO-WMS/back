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

import com.example.back.dto.response.ResponseDto;
import com.example.back.service.DepartmentService;
import com.example.back.dto.requset.department.PutDepartmentRequestDto;
import com.example.back.dto.response.department.GetDepartmentResponseDto;
import com.example.back.dto.requset.department.PostDepartmentCreateRequestDto;
import com.example.back.dto.response.department.GetDepartmentSearchResponseDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("wms/service/department")
@RequiredArgsConstructor

public class DepartmentController {
    
    private final DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create (
        @RequestBody @Valid PostDepartmentCreateRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = departmentService.create(requestBody);
        return response;
    }

    @GetMapping("/")
    public ResponseEntity<? super GetDepartmentResponseDto> getList(

    ) {
        ResponseEntity<? super GetDepartmentResponseDto> response = departmentService.getList();
        return response;
    }

    @DeleteMapping("/{departmentNo}")
    public ResponseEntity<ResponseDto> delete (
        @PathVariable("departmentNo") int departmentNo
    ) {
        ResponseEntity<ResponseDto> response = departmentService.delete(departmentNo);
        return response;
    }

    @PutMapping("/{departementNo}")
    public ResponseEntity<ResponseDto> put (
        @RequestBody @Valid PutDepartmentRequestDto requestBody,
        @PathVariable("departmentNo") int departmentNo
    ) {
        ResponseEntity<ResponseDto> response = departmentService.put(requestBody, departmentNo);
        return response;
    }

    @GetMapping("/search")
    public ResponseEntity<? super GetDepartmentSearchResponseDto> search(
        @RequestParam("search") String search
    ) {
        ResponseEntity<? super GetDepartmentSearchResponseDto> response = departmentService.search(search);
        return response;
    }
}
