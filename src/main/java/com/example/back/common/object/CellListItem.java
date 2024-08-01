package com.example.back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.example.back.entity.CellEntity;

import lombok.Getter;

@Getter

public class CellListItem {
    
    private Integer cellNo;
    private String cellCode; 
    private String cellName; 
    private String cellRackName;

    private CellListItem(CellEntity cellEntity) throws Exception {

        this.cellNo = cellEntity.getCellNo();
        this.cellCode = cellEntity.getCellCode();
        this.cellName = cellEntity.getCellName();
        this.cellRackName = cellEntity.getRack().getRackName();
    }

    public static List<CellListItem> getList(List<CellEntity> cellEntities) throws Exception {

        List<CellListItem> cellList = new ArrayList<>();
        for (CellEntity cellEntity: cellEntities) {
            CellListItem cellListItem = new CellListItem(cellEntity);
            cellList.add(cellListItem);
        }
        return cellList;
    }
}
