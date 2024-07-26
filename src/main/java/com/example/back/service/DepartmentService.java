package com.example.back.service;

import org.springframework.http.ResponseEntity;

import com.example.back.dto.requset.department.PostDepartmentCreateRequestDto;
import com.example.back.dto.requset.department.PutDepartmentRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.department.GetDepartmentResponseDto;
import com.example.back.dto.response.department.GetDepartmentSearchResponseDto;

public interface DepartmentService {

    ResponseEntity<ResponseDto> delete(int departmentNo);
    ResponseEntity<ResponseDto> create(PostDepartmentCreateRequestDto dto);
    ResponseEntity<ResponseDto> put(PutDepartmentRequestDto dto, int departmentNo);

    ResponseEntity<? super GetDepartmentResponseDto> getList();
    ResponseEntity<? super GetDepartmentSearchResponseDto> search(String search);

}
