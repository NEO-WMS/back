package com.example.back.dto.response.area;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.AreaEntity;

import lombok.Getter;

@Getter

public class GetAreaResponseDto extends ResponseDto {
    
    private Integer areaNo;
    private String areaCode;
    private String areaName;
    private String areaWarehouseName;
    
    private GetAreaResponseDto(AreaEntity areaEntity) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.areaNo = areaEntity.getAreaNo();
        this.areaCode = areaEntity.getAreaCode();
        this.areaName = areaEntity.getAreaName();
        this.areaWarehouseName = areaEntity.getWarehouse().getWarehouseName();
    }

    public static ResponseEntity<GetAreaResponseDto> success(AreaEntity areaEntity) throws Exception {

        GetAreaResponseDto responseBody = new GetAreaResponseDto(areaEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
