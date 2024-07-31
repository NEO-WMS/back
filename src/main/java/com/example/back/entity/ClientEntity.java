package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.back.dto.requset.client.PostClientCreateRequestDto;
import com.example.back.dto.requset.client.PutClientRequestDto;

import jakarta.persistence.Column;
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
    @Column(name = "client_no")
    private Integer clientNo;

    @Column(name = "client_code")
    private String clientCode;

    @Column(name = "client_category")
    private Integer clientCategory;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_owner")
    private String clientOwner;

    @Column(name = "client_tel")
    private String clientTel;

    @Column(name = "client_fax")
    private String clientFax;

    @Column(name = "client_bank")
    private String clientBank;

    @Column(name = "client_account")
    private String clientAccount;

    @Column(name = "client_zipcode")
    private String clientZipcode;

    @Column(name = "client_address1")
    private String clientAddress1;

    @Column(name = "client_address2")
    private String clientAddress2;

    @Column(name = "client_email")
    private String clientEmail;

    @Column(name = "client_business")
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

    public void update(PutClientRequestDto dto) {
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
