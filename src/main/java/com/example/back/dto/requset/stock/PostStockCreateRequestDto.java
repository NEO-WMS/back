package com.example.back.dto.requset.stock;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostStockCreateRequestDto {
    
    @NotNull
    private Integer inputWarehouseDetailItemNo;

    @NotNull
    private Integer inputWarehouseDetailQty;

    @NotNull
    private Integer inputWarehouseDetailWarehouseNo;

    @NotNull
    private Integer inputWarehouseDetailAreaNo;

    @NotNull
    private Integer inputWarehouseDetailRackNo;

    @NotNull
    private Integer inputWarehouseDetailCellNo;

    @NotBlank
    private String inputWarehouseDetailArrivalDate;
}
