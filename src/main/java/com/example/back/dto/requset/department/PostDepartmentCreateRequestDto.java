package com.example.back.dto.requset.department;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class PostDepartmentCreateRequestDto {

    @NotBlank
    private String departmentCode;

    @NotBlank
    private String departmentName;
    
}
