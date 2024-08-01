package com.example.back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.example.back.entity.WarehouseEntity;

import lombok.Getter;

@Getter

public class WarehouseListItem {
    
    private Integer warehouseNo;
    private String warehouseCode;
    private String warehouseName;

    private WarehouseListItem(WarehouseEntity warehouseEntity) throws Exception {

        this.warehouseNo = warehouseEntity.getWarehouseNo();
        this.warehouseCode = warehouseEntity.getWarehouseCode();
        this.warehouseName = warehouseEntity.getWarehouseName();
    }

    public static List<WarehouseListItem> getList(List<WarehouseEntity> warehouseEntities) throws Exception {

        List<WarehouseListItem> warehouseList = new ArrayList<>();
        for (WarehouseEntity warehouseEntity: warehouseEntities) {
            WarehouseListItem warehouseListItem = new WarehouseListItem(warehouseEntity);
            warehouseList.add(warehouseListItem);
        }
        return warehouseList;
    }
}
