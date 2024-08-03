package com.example.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.dto.requset.item.PostItemCreateRequestDto;
import com.example.back.dto.requset.item.PutItemRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.item.GetItemListResponseDto;
import com.example.back.dto.response.item.GetItemSearchResponseDto;
import com.example.back.service.ItemService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/wms/service/item")
@RequiredArgsConstructor

public class ItemController {
    
    private final ItemService itemService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create(
        @RequestBody @Valid PostItemCreateRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = itemService.create(requestBody);
        return response;
    }    

    @GetMapping("/")
    public ResponseEntity<? super GetItemListResponseDto> getList(

    ) {
        ResponseEntity<? super GetItemListResponseDto> response = itemService.getList();
        return response;
    }

    @DeleteMapping("/{itemNo}")
    public ResponseEntity<ResponseDto> delete (
        @PathVariable("itemNo") int itemNo
    ) {
        ResponseEntity<ResponseDto> response = itemService.delete(itemNo);
        return response;
    }

    @PutMapping("/{itemNo}")
    public ResponseEntity<ResponseDto> put (
        @RequestBody @Valid PutItemRequestDto requestBody,
        @PathVariable("itemNo") int itemNo
    ) {
        ResponseEntity<ResponseDto> response = itemService.put(requestBody, itemNo);
        return response;
    }

    @GetMapping("/search")
    public ResponseEntity<? super GetItemSearchResponseDto> search(
        @RequestParam("search") String search
    ) {
        ResponseEntity<? super GetItemSearchResponseDto> response = itemService.search(search);
        return response;
    }
}
