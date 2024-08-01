package com.example.back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.example.back.entity.RackEntity;

import lombok.Getter;

@Getter

public class RackListItem {

    private Integer rackNo;
    private String rackCode;
    private String rackName;
    private String rackAreaName;

    private RackListItem(RackEntity rackEntity) throws Exception {

        this.rackNo = rackEntity.getRackNo();
        this.rackCode = rackEntity.getRackCode();
        this.rackName = rackEntity.getRackName();
        this.rackAreaName = rackEntity.getArea().getAreaName();
    }
    
    public static List<RackListItem> getList(List<RackEntity> rackEntities) throws Exception {

        List<RackListItem> rackList = new ArrayList<>();
        for (RackEntity rackEntity: rackEntities) {
            RackListItem rackListItem = new RackListItem(rackEntity);
            rackList.add(rackListItem);
        }
        return rackList;
    }
    
}
