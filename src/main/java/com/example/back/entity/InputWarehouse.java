package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="input_warehouse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class InputWarehouse {

    @Id
    private Integer inputWarehouseNo;
    private Integer inputWarehouseMemberNo;
    private Integer inputWarehousePuchaseSheetNo;
    private String inputWarehouseStatus;

}
