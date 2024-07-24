package com.example.back.dto.requset.stock;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class PostStockWarehouseAddRequestDto {
    
    @NotBlank
    private String warehouseName;

    @NotBlank
    private String areaName;

    @NotBlank
    private String rackName;

    @NotBlank
    private String cellName;
    
}
