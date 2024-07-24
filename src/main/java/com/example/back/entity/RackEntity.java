package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.back.dto.requset.stock.PostStockWarehouseAddRequestDto;
import com.example.back.dto.requset.warehouse.PostWarehouseAreaRackCreateRequestDto;
import com.example.back.dto.requset.warehouse.PutWarehouseAreaRackRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="rack")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rackNo;
    private Integer rackAreaNo;
    private String rackCode;
    private String rackName;

    public RackEntity (PostWarehouseAreaRackCreateRequestDto dto) {
        this.rackCode = dto.getRackCode();
        this.rackName = dto.getRackName();
    }
    
    public RackEntity (PutWarehouseAreaRackRequestDto dto) {
        this.rackCode = dto.getRackCode();
        this.rackName = dto.getRackName();
    }

    public RackEntity (PostStockWarehouseAddRequestDto dto) {
        this.rackName = dto.getRackName();
    }

}
