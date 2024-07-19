package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="warehouse_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class WarehouseDetail {

    @Id
    private Integer warehouseDetailNo;
    private String warehouseDetailLotCode;
    private Integer warehouseDetailAmount;
    private Integer warehouseDetailOrderedAmount;
    private Integer warehouseDetailItemNo;
    private Integer warehouseDetailWareNo;
    private Integer warehouseDetailAreaNo;
    private Integer warehouseDetailRackNo;
    private Integer warehouseDetailCellNo;

}
