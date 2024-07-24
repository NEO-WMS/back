package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.back.dto.requset.stock.PostStockWarehouseAddRequestDto;
import com.example.back.dto.requset.warehouse.PostWarehouseCrateRequestDto;
import com.example.back.dto.requset.warehouse.PutWarehouseRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="warehouse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer warehouseNo;
    private String warehouseCode;
    private String warehouseName;

    public WarehouseEntity (PostWarehouseCrateRequestDto dto) {
        this.warehouseCode = dto.getWarehouseCode();
        this.warehouseName = dto.getWarehouseName();
    }

    public WarehouseEntity (PutWarehouseRequestDto dto) {
        this.warehouseCode = dto.getWarehouseCode();
        this.warehouseName = dto.getWarehouseName();
    }

    public WarehouseEntity(PostStockWarehouseAddRequestDto dto) 
    {
        this.warehouseName = dto.getWarehouseName();
    }

}
