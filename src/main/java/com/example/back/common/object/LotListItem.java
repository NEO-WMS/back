package com.example.back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.example.back.entity.LotEntity;

import lombok.Getter;

@Getter

public class LotListItem {
    
    private String lotCode;
    private Integer lotItemNo;
    private String itemCode;
    private String itemName;
    private Integer inputWarehouseDetailQty;

    private LotListItem(LotEntity lotEntity) throws Exception {

        this.lotCode = lotEntity.getLotCode();
        this.itemCode = lotEntity.getItem().getItemCode();
        this.itemName = lotEntity.getItem().getItemName();
        this.inputWarehouseDetailQty = lotEntity.getInputWarehouseDetail().getInputWarehouseDetailQty();
    }

    public static List<LotListItem> getList(List<LotEntity> lotEntities) throws Exception {

        List<LotListItem> lotList = new ArrayList<>();
        for (LotEntity lotEntity: lotEntities) {
            LotListItem lotListItem = new LotListItem(lotEntity);
            lotList.add(lotListItem);
        }
        return lotList;
    }
}
