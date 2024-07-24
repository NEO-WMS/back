package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.back.dto.requset.stock.PostStockWarehouseAddRequestDto;
import com.example.back.dto.requset.warehouse.PostWarehouseAreaCreateRequestDto;
import com.example.back.dto.requset.warehouse.PutWarehouseAreaRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="area")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AreaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer areaNo;
    private String areaCode;
    private String areaName;
    private Integer areaWareNo;

    public AreaEntity (PostWarehouseAreaCreateRequestDto dto) {
        this.areaCode = dto.getAreaCode();
        this.areaName = dto.getAreaName();
    }

    public AreaEntity (PutWarehouseAreaRequestDto dto) {
        this.areaCode = dto.getAreaCode();
        this.areaName = dto.getAreaName();
    }

    public AreaEntity (PostStockWarehouseAddRequestDto dto) {
        this.areaName = dto.getAreaName();
    }

}
