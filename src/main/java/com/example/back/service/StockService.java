package com.example.back.service;

import org.springframework.http.ResponseEntity;

import com.example.back.dto.requset.warehouseDetail.PostWarehouseDetailCreateRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.stock.GetStockItemListResponseDto;
import com.example.back.dto.response.stock.GetStockItemResponseDto;
import com.example.back.dto.response.stock.GetStockItemSearchResponseDto;
import com.example.back.dto.response.stock.GetStockMemberListResponseDto;
import com.example.back.dto.response.stock.GetStockMemberResponseDto;
import com.example.back.dto.response.stock.GetStockMemberSearchResponseDto;

public interface StockService {

    ResponseEntity<ResponseDto> create(PostWarehouseDetailCreateRequestDto dto);

    ResponseEntity<? super GetStockItemListResponseDto> getItemList();
    ResponseEntity<? super GetStockItemSearchResponseDto> searchItem(String search);
    ResponseEntity<? super GetStockItemResponseDto> getItem(int itemNo);

    ResponseEntity<? super GetStockMemberListResponseDto> getMemberList();
    ResponseEntity<? super GetStockMemberSearchResponseDto> searchMember(String search);
    ResponseEntity<? super GetStockMemberResponseDto> getMember(int memberNo);

}
