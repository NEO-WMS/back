package com.example.back.dto.requset.warehouse;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class PostWarehouseAreaCreateRequestDto {
    
    @NotBlank
    private String areaCode;
    
    @NotBlank
    private String areaName;
    
}
