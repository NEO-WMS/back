package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="warehouse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Warehouse {

    @Id
    private Integer warehouseNo;
    private String warehouseCode;
    private String warehouseName;

}
