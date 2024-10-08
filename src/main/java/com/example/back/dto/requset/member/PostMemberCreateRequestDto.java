package com.example.back.dto.requset.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class PostMemberCreateRequestDto {
    
    @NotBlank
    private String memberId;

    @NotBlank
    private String memberPw;

    @NotBlank
    private String memberName;

    @NotNull
    @Positive
    private Integer memberDepNo;
    
    @NotNull
    @Positive
    private Integer memberRankNo;

    @NotBlank
    private String memberEmail;
    
    private String memberImage;

    
}


