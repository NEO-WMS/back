package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.example.back.dto.requset.area.PostAreaCreateRequestDto;
import com.example.back.dto.requset.area.PutAreaRequestDto;
import com.example.back.dto.requset.stock.PostStockWarehouseAddRequestDto;

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

    @ManyToOne
    @JoinColumn(name = "area_ware_no")
    private WarehouseEntity warehouse;

    public AreaEntity (PostAreaCreateRequestDto dto) {
        this.areaCode = dto.getAreaCode();
        this.areaName = dto.getAreaName();
    }

    public void update (PutAreaRequestDto dto) {
        this.areaCode = dto.getAreaCode();
        this.areaName = dto.getAreaName();
    }

    public AreaEntity (PostStockWarehouseAddRequestDto dto) {
        this.areaName = dto.getAreaName();
    }

}
