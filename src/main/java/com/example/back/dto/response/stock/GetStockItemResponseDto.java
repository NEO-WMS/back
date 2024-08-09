package com.example.back.dto.response.stock;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.ItemEntity;

import lombok.Getter;

@Getter

public class GetStockItemResponseDto extends ResponseDto {

    private Integer itemNo;
    private String itemName;

    private GetStockItemResponseDto(ItemEntity itemEntity) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.itemNo = itemEntity.getItemNo();
        this.itemName = itemEntity.getItemName();
    }

    public static ResponseEntity<GetStockItemResponseDto> success(ItemEntity itemEntity) throws Exception {

        GetStockItemResponseDto responseBody = new GetStockItemResponseDto(itemEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
