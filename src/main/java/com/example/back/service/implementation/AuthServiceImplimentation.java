package com.example.back.service.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.back.dto.requset.auth.AuthSignInRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.auth.SignInResponseDto;
import com.example.back.entity.MemberEntity;
import com.example.back.provider.JwtProvider;
import com.example.back.repository.MemberRepository;
import com.example.back.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AuthServiceImplimentation implements AuthService {

    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(AuthSignInRequestDto dto) {

    String accessToken = null;

    try {

        String memberId = dto.getMemberId();
        String memberPw = dto.getMemberPw();

        MemberEntity memberEntity = memberRepository.findByMemberId(memberId);
        if (memberEntity == null)
        return ResponseDto.signInFailed();

        String encodedPassword = memberEntity.getMemberPw(); 
        boolean isMatched = passwordEncoder.matches(memberPw, encodedPassword);
        if (!isMatched) return ResponseDto.signInFailed();

        accessToken = jwtProvider.create(memberId);
        if (accessToken == null) return ResponseDto.tokenCreationFailed();

    } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
    }

    return SignInResponseDto.success(accessToken);

    }

}
