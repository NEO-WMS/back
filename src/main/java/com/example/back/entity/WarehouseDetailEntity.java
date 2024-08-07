package com.example.back.entity;

import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.example.back.dto.requset.warehouseDetail.PostWarehouseDetailCreateRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

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

public class WarehouseDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer warehouseDetailNo;
    private String warehouseDetailLotCode;
    private Integer warehouseDetailAmount;
    private Integer warehouseDetailOrderedAmount;
    private Integer warehouseDetailItemNo;

    @ManyToOne
    @JoinColumn(name = "inputWarehouseDetailWarehouseNo", referencedColumnName = "warehouseNo")
    private WarehouseEntity warehouse;

    @ManyToOne
    @JoinColumn(name = "inputWarehouseDetailAreaNo", referencedColumnName = "areaNo")
    private AreaEntity area;

    @ManyToOne
    @JoinColumn(name = "inputWarehouseDetailRackNo", referencedColumnName = "rackNo")
    private RackEntity rack;

    @ManyToOne
    @JoinColumn(name = "inputWarehouseDetailCellNo", referencedColumnName = "cellNo")
    private CellEntity cell;

    public WarehouseDetailEntity(PostWarehouseDetailCreateRequestDto dto, WarehouseEntity warehouse, AreaEntity area, RackEntity rack, CellEntity cell) {
        this.warehouseDetailItemNo = dto.getWarehouseDetailItemNo();
        this.warehouseDetailAmount = dto.getWarehouseDetailAmount();
        this.warehouse = warehouse;
        this.area = area;
        this.rack = rack;
        this.cell = cell;
    }

}
