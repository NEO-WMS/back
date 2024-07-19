package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

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

public class Area {
    
    @Id
    private Integer areaNo;
    private String areaCode;
    private String areaName;
    private Integer areaWareNo;

}
