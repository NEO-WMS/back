package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.back.dto.requset.client.PostClientCreateRequestDto;
import com.example.back.dto.requset.client.PutClientRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientNo;    
    private String clientCode;
    private Integer clientCategory;
    private String clientName;
    private String clientOwner;
    private String clientTel;
    private String clientFax;
    private String clientBank;
    private String clientAccount;
    private String clientZipcode;
    private String clientAddress1;
    private String clientAddress2;
    private String clientEmail;
    private String clientBusiness;

    public ClientEntity(PostClientCreateRequestDto dto) {
        this.clientCode = dto.getClientCode();
        this.clientCategory = dto.getClientCategory();
        this.clientName = dto.getClientName();
        this.clientOwner = dto.getClientOwner();
        this.clientTel = dto.getClientTel();
        this.clientFax = dto.getClientFax();
        this.clientBank = dto.getClientBank();
        this.clientAccount = dto.getClientAccount();
        this.clientZipcode = dto.getClientZipcode();
        this.clientAddress1 = dto.getClientAddress1();
        this.clientAddress2 = dto.getClientAddress2();
        this.clientEmail = dto.getClientEmail();
        this.clientBusiness = dto.getClientBusiness();
    }

    public ClientEntity(PutClientRequestDto dto) {
        this.clientCode = dto.getClientCode();
        this.clientCategory = dto.getClientCategory();
        this.clientName = dto.getClientName();
        this.clientOwner = dto.getClientOwner();
        this.clientTel = dto.getClientTel();
        this.clientFax = dto.getClientFax();
        this.clientBank = dto.getClientBank();
        this.clientAccount = dto.getClientAccount();
        this.clientZipcode = dto.getClientZipcode();
        this.clientAddress1 = dto.getClientAddress1();
        this.clientAddress2 = dto.getClientAddress2();
        this.clientEmail = dto.getClientEmail();
        this.clientBusiness = dto.getClientBusiness();
    }

}
