package com.example.back.common.object;

import java.util.List;
import java.util.ArrayList;

import com.example.back.entity.DepartmentEntity;

import lombok.Getter;

@Getter

public class DepartmentListItem {
    
    private Integer departmentNo;
    private String departmentCode;
    private String departmentName;

    private DepartmentListItem(DepartmentEntity departmentEntity) throws Exception {
        this.departmentNo = departmentEntity.getDepartmentNo();
        this.departmentCode = departmentEntity.getDepartmentCode();
        this.departmentName = departmentEntity.getDepartmentName();
    }

    public static List<DepartmentListItem> getList(List<DepartmentEntity> departmentEntities) throws Exception {

        List<DepartmentListItem> departmentList = new ArrayList<>();
        for (DepartmentEntity departmentEntity: departmentEntities) {
            DepartmentListItem departmentListitem = new DepartmentListItem(departmentEntity);
            departmentList.add(departmentListitem);
        }
        return departmentList;
    }

}
