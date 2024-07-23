package com.example.back.dto.requset.member;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class MemberSignInRequestDto {
    
    @NotBlank
    private String memberId;

    @NotBlank
    private String memberPw;
}
