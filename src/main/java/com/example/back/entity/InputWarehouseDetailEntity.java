package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

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
    private String  inputWarehouseDetailArrivalDate;
    private Integer inputWarehouseDetailQty;

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

    private Integer inputWarehouseDetailLotNo;
    private Integer inputWarehouseDetailItemNo;

    @OneToMany(mappedBy = "inputWarehouseDetail", cascade = CascadeType.ALL)
    private List<LotEntity> lots;

}
