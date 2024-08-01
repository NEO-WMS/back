package com.example.back.dto.requset.warehouse;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PostWarehouseCreateRequestDto {
    
    @NotBlank
    private String warehouseCode;
    
    @NotBlank
    private String warehouseName;
}
