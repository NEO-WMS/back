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
@Table(name="item_movement_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemMovementHistoryEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemMovementHistoryNo;
    private String itemMovementHistoryLotNo;
    private Integer itemMovementHistoryItemNo;
    private Integer itemMovementHistoryAmount;
    private String itemMovementHistoryDay;
    private Integer itemMovementHistoryPrWareNo;
    private Integer itemMovementHistoryPrAreaNo;
    private Integer itemMovementHistoryPrRackNo;
    private Integer itemMovementHistoryPrCellNo;
    private Integer itemMovementHistoryWareNo;
    private Integer itemMovementHistoryAreaNo;
    private Integer itemMovementHistoryRackNo;
    private Integer itemMovementHistoryCellNo;
    
}
