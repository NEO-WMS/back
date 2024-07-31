package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "lot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lotNo;
    
    private String lotCode;

    @ManyToOne
    @JoinColumn(name = "lot_item_no", insertable = false, updatable = false)
    private ItemEntity item;

    @ManyToOne
    @JoinColumn(name = "input_warehouse_detail", insertable = false, updatable = false)
    private InputWarehouseDetailEntity inputWarehouseDetail;
}
