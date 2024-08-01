package com.example.back.service;

import org.springframework.http.ResponseEntity;

import com.example.back.dto.requset.area.PostAreaCreateRequestDto;
import com.example.back.dto.requset.area.PutAreaRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.area.GetAreaListResponseDto;
import com.example.back.dto.response.area.GetAreaResponseDto;

public interface AreaService {

    ResponseEntity<ResponseDto> delete(int areaNo);
    ResponseEntity<ResponseDto> create(PostAreaCreateRequestDto dto);
    ResponseEntity<ResponseDto> put(PutAreaRequestDto dto, int areaNo);

    ResponseEntity<? super GetAreaListResponseDto> getList();
    ResponseEntity<? super GetAreaResponseDto> getArea(int areaNo);
    
}
