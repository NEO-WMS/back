package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.back.common.util.ChangeDateFormatUtil;
import com.example.back.dto.requset.stock.PostStockCreateRequestDto;

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
import java.time.LocalDate;

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
    private LocalDate  inputWarehouseDetailArrivalDate;
    private Integer inputWarehouseDetailQty;
    private Integer inputWarehouseDetailWarehouseNo;
    private Integer inputWarehouseDetailAreaNo;
    private Integer inputWarehouseDetailRackNo;
    private Integer inputWarehouseDetailCellNo;
    private Integer inputWarehouseDetailLotNo;
    private Integer inputWarehouseDetailItemNo;

    @OneToMany(mappedBy = "inputWarehouseDetail", cascade = CascadeType.ALL)
    private List<LotEntity> lots;

    public InputWarehouseDetailEntity(PostStockCreateRequestDto dto) {
        this.inputWarehouseDetailItemNo = dto.getInputWarehouseDetailItemNo();
        this.inputWarehouseDetailQty = dto.getInputWarehouseDetailQty();
        this.inputWarehouseDetailWarehouseNo = dto.getInputWarehouseDetailWarehouseNo();
        this.inputWarehouseDetailAreaNo = dto.getInputWarehouseDetailAreaNo();
        this.inputWarehouseDetailRackNo = dto.getInputWarehouseDetailRackNo();
        this.inputWarehouseDetailCellNo = dto.getInputWarehouseDetailCellNo();
        this.inputWarehouseDetailArrivalDate = ChangeDateFormatUtil.parseDate(dto.getInputWarehouseDetailArrivalDate());
    }
}
