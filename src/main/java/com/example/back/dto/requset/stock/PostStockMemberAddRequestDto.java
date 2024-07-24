package com.example.back.dto.requset.stock;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class PostStockMemberAddRequestDto {
    
    @NotBlank
    private String memberName;

}
