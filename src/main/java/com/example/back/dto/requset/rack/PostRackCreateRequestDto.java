package com.example.back.dto.requset.rack;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PostRackCreateRequestDto {
    
    @NotBlank
    private String rackCode;
    
    @NotBlank
    private String rackName;
}
