package com.example.back.service;

import org.springframework.http.ResponseEntity;

import com.example.back.dto.requset.auth.AuthSignInRequestDto;
import com.example.back.dto.response.auth.SignInResponseDto;

public interface AuthService {
    
    ResponseEntity<? super SignInResponseDto> signIn(AuthSignInRequestDto dto);
}
