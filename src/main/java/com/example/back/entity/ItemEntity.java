package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.back.dto.requset.item.PostItemCreateRequestDto;
import com.example.back.dto.requset.item.PutItemRequestDto;
import com.example.back.dto.requset.stock.PostStockItemAddRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

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

public class ItemEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemNo;
    private Integer itemClientNo;
    private String itemCode;
    private String itemName;
    private Integer itemInPrice;
    private Integer itemOutPrice;
    private String itemImage;

    public ItemEntity (PostItemCreateRequestDto dto) {

        this.itemClientNo = dto.getItemClientNo();
        this.itemCode = dto.getItemCode();
        this.itemName = dto.getItemName();
        this.itemInPrice = dto.getItemInPrice();
        this.itemOutPrice = dto.getItemOutPrice();
        this.itemImage = dto.getItemImage();

    }

    public ItemEntity (PutItemRequestDto dto) {

        this.itemClientNo = dto.getItemClientNo();
        this.itemCode = dto.getItemCode();
        this.itemName = dto.getItemName();
        this.itemInPrice = dto.getItemInPrice();
        this.itemOutPrice = dto.getItemOutPrice();
        this.itemImage = dto.getItemImage();

    }

    public ItemEntity (PostStockItemAddRequestDto dto) {
        this.itemName = dto.getItemName();
    }

}