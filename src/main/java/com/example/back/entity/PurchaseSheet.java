package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="purchase_sheet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PurchaseSheet {

    @Id
    private Integer purchaseSheetNo;
    private String purchaseSheetDay;
    private String purchaseSheetDeliveryDate;
    private Integer purchaseSheetStatus;
    private Integer purchaseSheetOrderNo;
    private Integer purchaseSheetMemberNo;
    private Integer purchaseSheetClientNo;

}
