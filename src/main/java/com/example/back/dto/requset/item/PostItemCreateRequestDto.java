package com.example.back.dto.requset.item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class PostItemCreateRequestDto {

    @NotNull
    private Integer itemClientNo;
    
    @NotBlank
    private String itemCode;
    
    @NotBlank
    private String itemName;
    
    @NotNull
    private Integer itemInPrice;
    
    @NotNull
    private Integer itemOutPrice;
    
    private String itemImage;

}
