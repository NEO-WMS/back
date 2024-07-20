package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

public class Client {

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

}
