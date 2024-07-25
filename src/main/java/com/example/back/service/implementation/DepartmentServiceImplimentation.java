package com.example.back.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.back.dto.requset.department.PostDepartmentCreateRequestDto;
import com.example.back.dto.requset.department.PutDepartmentRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.department.GetDepartmentResponseDto;
import com.example.back.dto.response.department.GetDepartmentSearchResponseDto;
import com.example.back.entity.DepartmentEntity;
import com.example.back.repository.DepartmentRepository;
import com.example.back.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class DepartmentServiceImplimentation implements DepartmentService {
    

    @Autowired
    private final DepartmentRepository departmentRepository;

    @Override
    public ResponseEntity<ResponseDto> create(PostDepartmentCreateRequestDto dto) {
        
        try {

            DepartmentEntity departmentEntity = new DepartmentEntity(dto);
            departmentRepository.save(departmentEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetDepartmentResponseDto> getList() {

        try {
            List<DepartmentEntity> departmentEntities = departmentRepository.findByOrderByDepartmentNoDesc();
            return GetDepartmentResponseDto.success(departmentEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<ResponseDto> delete(int departmentNo) {

        try {
            
            DepartmentEntity departmentEntity = departmentRepository.findByDepartmentNo(departmentNo);
            if (departmentEntity == null) return ResponseDto.noExistDepartment();

            departmentRepository.delete(departmentEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> put(PutDepartmentRequestDto dto, int departmentNo) {
        
        try {
            DepartmentEntity departmentEntity = departmentRepository.findByDepartmentNo(departmentNo);
            if(departmentEntity == null) return ResponseDto.noExistDepartment();

            departmentEntity.update(dto);
            departmentRepository.save(departmentEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetDepartmentSearchResponseDto> search(String searchWord) {
        try {

            if (searchWord == null || searchWord.trim().isEmpty()) {
                List<DepartmentEntity> departmentEntities = departmentRepository.findByOrderByDepartmentNoDesc();
                return GetDepartmentSearchResponseDto.success(departmentEntities);
            }

            List<DepartmentEntity> departmentEntities = departmentRepository.search(searchWord);
            return GetDepartmentSearchResponseDto.success(departmentEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

}
