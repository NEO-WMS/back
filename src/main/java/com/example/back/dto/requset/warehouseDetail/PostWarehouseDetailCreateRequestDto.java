package com.example.back.dto.requset.warehouseDetail;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PostWarehouseDetailCreateRequestDto {
    
    @NotNull
    private Integer warehouseDetailItemNo;

    @NotNull
    private Integer warehouseDetailAmount;

    @NotNull
    private Integer warehouseDetailwarehouseNo;

    @NotNull
    private Integer warehouseDetailAreaNo;

    @NotNull
    private Integer warehouseDetailRackNo;

    @NotNull
    private Integer warehouseDetailCellNo;
}
