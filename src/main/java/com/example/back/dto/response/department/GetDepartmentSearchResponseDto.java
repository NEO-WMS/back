package com.example.back.dto.response.department;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.common.object.DepartmentListItem;
import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.DepartmentEntity;

import lombok.Getter;

@Getter

public class GetDepartmentSearchResponseDto extends ResponseDto {
    
    private List<DepartmentListItem> departmentList;

    private GetDepartmentSearchResponseDto(List<DepartmentEntity> departmentEntities) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.departmentList = DepartmentListItem.getList(departmentEntities);
    }

    public static ResponseEntity<GetDepartmentSearchResponseDto> success(List<DepartmentEntity> departmentEntities) throws Exception {
        GetDepartmentSearchResponseDto responseBody = new GetDepartmentSearchResponseDto(departmentEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
