package com.example.back.dto.response.item;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.common.object.ItemListItem;
import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.ItemEntity;

import lombok.Getter;

@Getter

public class GetItemListResponseDto extends ResponseDto {
    
    private List<ItemListItem> itemList;

    private GetItemListResponseDto(List<ItemEntity> itemEntities) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.itemList =ItemListItem.getList(itemEntities);
    }

    public static ResponseEntity<GetItemListResponseDto> success(List<ItemEntity> itemEntities) throws Exception {
        GetItemListResponseDto responseBody = new GetItemListResponseDto(itemEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
