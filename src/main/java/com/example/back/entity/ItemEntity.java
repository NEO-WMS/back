package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemNo;

    @ManyToOne
    @JoinColumn(name = "item_client_no")
    private ClientEntity client;

    private String itemCode;
    private String itemName;
    private Integer itemInPrice;
    private Integer itemOutPrice;
    private String itemImage;

    public ItemEntity(PostItemCreateRequestDto dto) {
        this.client = new ClientEntity();
        this.client.setClientNo(dto.getItemClientNo());
        this.itemCode = dto.getItemCode();
        this.itemName = dto.getItemName();
        this.itemInPrice = dto.getItemInPrice();
        this.itemOutPrice = dto.getItemOutPrice();
        this.itemImage = dto.getItemImage();
    }

    public void update(PutItemRequestDto dto) {
        this.client.setClientNo(dto.getItemClientNo());
        this.itemCode = dto.getItemCode();
        this.itemName = dto.getItemName();
        this.itemInPrice = dto.getItemInPrice();
        this.itemOutPrice = dto.getItemOutPrice();
        this.itemImage = dto.getItemImage();
    }

    public ItemEntity(PostStockItemAddRequestDto dto) {
        this.itemName = dto.getItemName();
    }
}
