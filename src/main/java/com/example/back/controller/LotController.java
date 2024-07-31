package com.example.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.service.LotService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/wms/service/lot")
@RequiredArgsConstructor

public class LotController {
    
    private final LotService lotService;

    // @GetMapping("/")
    // public ResponseEntity<>
}
