package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Item {
    
    @Id
    private Integer itemNo;
    private Integer itemClientNo;
    private String itemCode;
    private String itemName;
    private Integer itemInPrice;
    private Integer itemOutPrice;
    private String itemImage;

}
