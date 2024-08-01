package com.example.back.dto.response.warehouse;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.common.object.WarehouseListItem;
import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.WarehouseEntity;

import lombok.Getter;

@Getter

public class GetWarehouseListResponseDto extends ResponseDto {
    
    private List<WarehouseListItem> warehouseList;

    private GetWarehouseListResponseDto(List<WarehouseEntity> warehouseEntities) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.warehouseList = WarehouseListItem.getList(warehouseEntities);
    }

    public static ResponseEntity<GetWarehouseListResponseDto> success(List<WarehouseEntity> warehouseEntities) throws Exception {

        GetWarehouseListResponseDto responseBody = new GetWarehouseListResponseDto(warehouseEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
