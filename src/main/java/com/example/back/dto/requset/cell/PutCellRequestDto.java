package com.example.back.dto.requset.cell;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PutCellRequestDto {
    
    @NotBlank
    private String cellCode;
    
    @NotBlank
    private String cellName;
}
