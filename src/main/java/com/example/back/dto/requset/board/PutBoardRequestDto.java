package com.example.back.dto.requset.board;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class PutBoardRequestDto {
    
    @NotBlank
    private String boardTitle;

    @NotBlank
    private String boardContent;
    
}
