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

import com.example.back.dto.requset.client.PostClientCreateRequestDto;
import com.example.back.dto.requset.client.PutClientRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.client.GetClientListResponseDto;
import com.example.back.dto.response.client.GetClientSearchResponseDto;
import com.example.back.service.ClientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/wms/service/client")
@RequiredArgsConstructor

public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create (
        @RequestBody @Valid PostClientCreateRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = clientService.create(requestBody);
        return response;
    }

    @GetMapping("/")
    public ResponseEntity<? super GetClientListResponseDto> getList(

    ) {
        ResponseEntity<? super GetClientListResponseDto> response = clientService.getList();
        return response;
    }

    @DeleteMapping("/{clientNo}")
    public ResponseEntity<ResponseDto> delete (
        @PathVariable("clientNo") int clientNo
    ) {
        ResponseEntity<ResponseDto> response = clientService.delete(clientNo);
        return response;
    }

    @PutMapping("/{clientNo}")
    public ResponseEntity<ResponseDto> put (
        @RequestBody @Valid PutClientRequestDto requestBody,
        @PathVariable("clientNo") int clientNo
    ) {
        ResponseEntity<ResponseDto> response = clientService.put(requestBody, clientNo);
        return response;
    }

    @GetMapping("/search")
    public ResponseEntity<? super GetClientSearchResponseDto> search(
        @RequestParam("search") String search
    ) {
        ResponseEntity<? super GetClientSearchResponseDto> response = clientService.search(search);
        return response;
    }

    @GetMapping("/order")
    public ResponseEntity<? super GetClientListResponseDto> getListByOrderCategory  (

    ) {
        ResponseEntity<? super GetClientListResponseDto> response = clientService.getListByOrderCategory(1);
        return response;
    }

    @GetMapping("/ordering")
    public ResponseEntity<? super GetClientListResponseDto> getListByOrderingCategory  (

    ) {
        ResponseEntity<? super GetClientListResponseDto> response = clientService.getListByOrderingCategory(2);
        return response;
    }




    
}
