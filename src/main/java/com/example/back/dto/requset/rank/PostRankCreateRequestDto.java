package com.example.back.dto.requset.rank;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class PostRankCreateRequestDto {
    
    @NotBlank
    private String rankCode;

    @NotBlank
    private String rankName;

}
