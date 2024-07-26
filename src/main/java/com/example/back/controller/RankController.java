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

import com.example.back.dto.requset.rank.PostRankCreateRequestDto;
import com.example.back.dto.requset.rank.PutRankRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.rank.GetRankResponseDto;
import com.example.back.dto.response.rank.GetRankSearchResponseDto;
import com.example.back.service.RankService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("wms/service/rank")
@RequiredArgsConstructor

public class RankController {

    private final RankService rankService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create (
        @RequestBody @Valid PostRankCreateRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = rankService.create(requestBody);
        return response;
    }

    @GetMapping("/")
    public ResponseEntity<? super GetRankResponseDto> getList(

    ) {
        ResponseEntity<? super GetRankResponseDto> response = rankService.getList();
        return response;
    }

    @DeleteMapping("/{rankNo}")
    public ResponseEntity<ResponseDto> delete (
        @PathVariable("rankNo") int rankNo
    ) {
        ResponseEntity<ResponseDto> response = rankService.delete(rankNo);
        return response;
    }
    
    @PutMapping("/{rankNo}")
    public ResponseEntity<ResponseDto> put (
        @RequestBody @Valid PutRankRequestDto requestBody,
        @PathVariable("rankNo") int rankNo
    ) {
        ResponseEntity<ResponseDto> response = rankService.put(requestBody, rankNo);
        return response;
    }
    
    @GetMapping("/search")
    public ResponseEntity<? super GetRankSearchResponseDto> search(
        @RequestParam("search") String search
    ) {
        ResponseEntity<? super GetRankSearchResponseDto> response = rankService.search(search);
        return response;
    }

}
