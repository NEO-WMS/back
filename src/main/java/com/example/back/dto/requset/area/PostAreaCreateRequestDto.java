package com.example.back.dto.requset.area;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PostAreaCreateRequestDto {
    
    @NotBlank
    private String areaCode;
    
    @NotBlank
    private String areaName;

    @NotNull
    private Integer warehouseNo;

}
