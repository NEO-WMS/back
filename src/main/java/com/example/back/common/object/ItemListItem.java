package com.example.back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.example.back.entity.ItemEntity;

import lombok.Getter;

@Getter

public class ItemListItem {

    private Integer itemNo;
    private String clientName;
    private String itemCode;
    private String itemName;
    private Integer itemInPrice;
    private Integer itemOutPrice;
    private String itemImage;

    private ItemListItem(ItemEntity itemEntity) throws Exception {

        this.itemNo = itemEntity.getItemNo();
        this.clientName = itemEntity.getClient().getClientName();
        this.itemCode = itemEntity.getItemCode();
        this.itemName = itemEntity.getItemName();
        this.itemInPrice = itemEntity.getItemInPrice();
        this.itemOutPrice = itemEntity.getItemOutPrice();
        this.itemImage = itemEntity.getItemImage();
    }

    public static List<ItemListItem> getList(List<ItemEntity> itemEntities) throws Exception {

        List<ItemListItem> itemList = new ArrayList<>();
        for (ItemEntity itemEntity: itemEntities) {
            ItemListItem itemListItem = new ItemListItem(itemEntity);
            itemList.add(itemListItem);
        }
        return itemList;
    }
}
