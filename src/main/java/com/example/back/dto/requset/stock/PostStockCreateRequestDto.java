package com.example.back.dto.requset.stock;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PostStockCreateRequestDto {
    
    @NotBlank
    private Integer inputWarehouseDetailItemNo;

    @NotBlank
    private Integer inputWarehouseDetailQty;

    @NotBlank
    private Integer inputWarehouseDetailwarehouseNo;

    @NotBlank
    private Integer inputWarehouseDetailareaNo;

    @NotBlank
    private Integer inputWarehouseDetailrackNo;

    @NotBlank
    private Integer inputWarehouseDetailcellNo;

}
