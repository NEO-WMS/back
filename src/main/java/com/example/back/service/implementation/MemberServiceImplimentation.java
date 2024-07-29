package com.example.back.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.back.dto.requset.member.PostMemberCreateRequestDto;
import com.example.back.dto.requset.member.PutMemberRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.member.GetMemberResponseDto;
import com.example.back.dto.response.member.GetmemberSearchResponseDto;
import com.example.back.entity.MemberEntity;
import com.example.back.provider.JwtProvider;
import com.example.back.repository.MemberRepository;
import com.example.back.service.MemberService;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class MemberServiceImplimentation implements MemberService {
        
    @Autowired
    private final MemberRepository memberRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<ResponseDto> create (PostMemberCreateRequestDto dto) {

        try {

            String memberId = dto.getMemberId();
            String memberPw = dto.getMemberPw();

            boolean existedMemberId = memberRepository.existsByMemberId(memberId);
            if (existedMemberId) return ResponseDto.duplicatedId();

            String encodePassword = passwordEncoder.encode(memberPw);
            dto.setMemberPw(encodePassword);

            MemberEntity memberEntity = new MemberEntity(dto);
            memberRepository.save(memberEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetMemberResponseDto> getList() {

        try {
            List<MemberEntity> memberEntities = memberRepository.findByOrderByMemberNoDesc();
            return GetMemberResponseDto.success(memberEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<ResponseDto> delete(int memberNo) {

        try {
            MemberEntity memberEntity = memberRepository.findByMemberNo(memberNo);
            if (memberEntity == null) return ResponseDto.noExistMember();

            memberRepository.delete(memberEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> put(PutMemberRequestDto dto, int memberNo) {

        try {
            MemberEntity memberEntity = memberRepository.findByMemberNo(memberNo);
            if (memberEntity == null) return ResponseDto.noExistMember();

            memberEntity.update(dto);
            memberRepository.save(memberEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetmemberSearchResponseDto> search(String search) {

        try {
            if (search == null || search.trim().isEmpty()) {
                List<MemberEntity> memberEntities = memberRepository.findByOrderByMemberNoDesc();
                return GetmemberSearchResponseDto.success(memberEntities);
            }

            List<MemberEntity> memberEntities = memberRepository.search(search);
            return GetmemberSearchResponseDto.success(memberEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
}
