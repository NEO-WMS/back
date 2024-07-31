package com.example.back.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.back.dto.requset.item.PostItemCreateRequestDto;
import com.example.back.dto.requset.item.PutItemRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.item.GetItemResponseDto;
import com.example.back.dto.response.item.GetItemSearchResponseDto;
import com.example.back.entity.ItemEntity;
import com.example.back.repository.ItemRepositoy;
import com.example.back.service.ItemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ItemServiceImplimentation implements ItemService {
    
    @Autowired
    private final ItemRepositoy itemRepositoy;

    @Override
    public ResponseEntity<ResponseDto> create(PostItemCreateRequestDto dto) {

        try {
            ItemEntity itemEntity = new ItemEntity(dto);
            itemRepositoy.save(itemEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetItemResponseDto> getList() {

        try {
            List<ItemEntity> itemEntities = itemRepositoy.findByOrderByItemNoDesc();
            return GetItemResponseDto.success(itemEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<ResponseDto> delete(int itemNo) {

        try {
            ItemEntity itemEntity =itemRepositoy.findByItemNo(itemNo);
            if (itemEntity == null) return ResponseDto.noExistItem();

            itemRepositoy.delete(itemEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> put(PutItemRequestDto dto, int itemNo) {

        try {
            ItemEntity itemEntity = itemRepositoy.findByItemNo(itemNo);
            if (itemEntity == null) return ResponseDto.noExistItem();

            itemEntity.update(dto);
            itemRepositoy.save(itemEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetItemSearchResponseDto> search(String search) {
        try {
            if (search == null || search.trim().isEmpty()) {
                List<ItemEntity> itemEntities = itemRepositoy.findByOrderByItemNoDesc();
                return GetItemSearchResponseDto.success(itemEntities);
            }

            List<ItemEntity> itemEntities = itemRepositoy.search(search);
            return GetItemSearchResponseDto.success(itemEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
}
