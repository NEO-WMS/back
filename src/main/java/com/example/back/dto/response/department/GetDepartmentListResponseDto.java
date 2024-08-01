package com.example.back.dto.response.department;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.entity.DepartmentEntity;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.common.object.DepartmentListItem;

import lombok.Getter;

@Getter

public class GetDepartmentListResponseDto extends ResponseDto {
    
    private List<DepartmentListItem> departmentList;

    private GetDepartmentListResponseDto(List<DepartmentEntity> departmentEntities) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.departmentList = DepartmentListItem.getList(departmentEntities);
    }

    public static ResponseEntity<GetDepartmentListResponseDto> success(List<DepartmentEntity> departmentEntities) throws Exception {
        GetDepartmentListResponseDto responseBody = new GetDepartmentListResponseDto(departmentEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
