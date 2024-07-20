package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="sell_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SellDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sellDetailNo;
    private Integer sellDetailItemNo;
    private Integer sellDetailAmount;
    private Integer sellDetailSellPrice;
    private Integer sellDetailLotNo;
    private Integer sellDetailSellDetailNo;

}
