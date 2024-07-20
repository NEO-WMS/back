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
@Table(name="input_warehouse_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class InputWarehouseDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inputWarehouseDetailNo;
    private Integer inputWarehouseDetailInputWarehouseNo;
    private Integer inputWarehouseDetailPurchaseSheetDetailNo;
    private Integer inputWarehouseDetailStatus;
    private String inputWarehouseDetailArrivalDate;
    private Integer inputWarehouseDetailQty;
    private Integer inputWarehouseDetailWareNo;
    private Integer inputWarehouseDetailAreaNo;
    private Integer inputWarehouseDetailRackNo;
    private Integer inputWarehouseDetailCellNo;
    private Integer inputWarehouseDetailLotNo;
    private Integer inputWarehouseDetailItemNo;

}
