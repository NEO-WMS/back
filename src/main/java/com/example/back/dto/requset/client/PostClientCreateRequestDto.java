package com.example.back.dto.requset.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class PostClientCreateRequestDto {

    @NotBlank
    private String clientCode;

    @NotNull
    private Integer clientCategory;

    @NotBlank
    private String clientName;

    @NotBlank
    private String clientOwner;

    @NotBlank
    private String clientTel;

    private String clientFax;

    private String clientBank;

    private String clientAccount;

    private String clientZipcode;

    private String clientAddress1;

    private String clientAddress2;

    private String clientEmail;

    private String clientBusiness;
    
}
