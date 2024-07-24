package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.back.dto.requset.warehouse.PostWarehouseAreaRackCellCreateRequestDto;
import com.example.back.dto.requset.warehouse.PutWarehouseAreaRackCellRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="cell")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CellEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cellNo;
    private Integer cellRackNo;
    private String cellCode;
    private String cellName;

    public CellEntity (PostWarehouseAreaRackCellCreateRequestDto dto) {
        this.cellCode = dto.getCellCode();
        this.cellName = dto.getCellName();
    }

    public CellEntity (PutWarehouseAreaRackCellRequestDto dto) {
        this.cellCode = dto.getCellCode();
        this.cellName = dto.getCellName();
    }

}
