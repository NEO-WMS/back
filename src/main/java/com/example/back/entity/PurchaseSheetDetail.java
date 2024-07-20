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
@Table(name="purchase_sheet_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PurchaseSheetDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer purchaseSheetDetailNo;
    private Integer purchaseSheetDetailPurchaseSheetNo;
    private Integer purchaseSheetDetailOrderDetailNo;
    private Integer purchaseSheetDetailAmount;
    private Integer purchaseSheetDetailStatus;
    private Integer purchaseSheetDetailItemNo;
    private Integer purchaseSheetDetailWareNo;

}
