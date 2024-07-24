package com.example.back.dto.requset.warehouse;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class PostWarehouseAreaRackCellCreateRequestDto {
    
    @NotBlank
    private String cellCode;

    @NotBlank
    private String cellName;

}
