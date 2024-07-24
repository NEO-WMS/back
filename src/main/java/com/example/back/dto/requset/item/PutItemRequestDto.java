package com.example.back.dto.requset.item;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class PutItemRequestDto {
    
    @NotBlank
    private Integer itemClientNo;
    
    @NotBlank
    private String itemCode;
    
    @NotBlank
    private String itemName;
    
    @NotBlank
    private Integer itemInPrice;
    
    @NotBlank
    private Integer itemOutPrice;
    
    private String itemImage;

}