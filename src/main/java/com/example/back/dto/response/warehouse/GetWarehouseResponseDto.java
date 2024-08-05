package com.example.back.dto.response.warehouse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.WarehouseEntity;

import lombok.Getter;

@Getter

public class GetWarehouseResponseDto extends ResponseDto {
    
    private Integer warehouseNo;
    private String warehouseCode;
    private String warehouseName;

    private GetWarehouseResponseDto(WarehouseEntity warehouseEntity) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.warehouseNo = warehouseEntity.getWarehouseNo();
        this.warehouseCode = warehouseEntity.getWarehouseCode();
        this.warehouseName = warehouseEntity.getWarehouseName();
    }

    public static ResponseEntity<GetWarehouseResponseDto> success(WarehouseEntity warehouseEntity) throws Exception {

        GetWarehouseResponseDto responseBody = new GetWarehouseResponseDto(warehouseEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
