package com.example.back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.example.back.entity.AreaEntity;

import lombok.Getter;

@Getter

public class AreaListItem {

    private Integer areaNo;
    private String areaCode;
    private String areaName;
    private String areaWareName;

    private AreaListItem(AreaEntity areaEntity) throws Exception {

        this.areaNo = areaEntity.getAreaNo();
        this.areaCode = areaEntity.getAreaCode();
        this.areaName = areaEntity.getAreaName();
        this.areaWareName = areaEntity.getWarehouse().getWarehouseName();
    }
    
    public static List<AreaListItem> getList(List<AreaEntity> areaEntities) throws Exception {

        List<AreaListItem> areaList = new ArrayList<>();
        for (AreaEntity areaEntity: areaEntities) {
            AreaListItem areaListItem = new AreaListItem(areaEntity);
            areaList.add(areaListItem);
        }
        return areaList;
    }

}
