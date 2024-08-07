package com.example.back.entity;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.example.back.dto.requset.area.PostAreaCreateRequestDto;
import com.example.back.dto.requset.area.PutAreaRequestDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="area")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AreaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer areaNo;
    private String areaCode;
    private String areaName;

    @ManyToOne
    @JoinColumn(name = "area_ware_no")
    private WarehouseEntity warehouse;

    public AreaEntity (PostAreaCreateRequestDto dto) {
        this.areaCode = dto.getAreaCode();
        this.areaName = dto.getAreaName();
    }

    public void update (PutAreaRequestDto dto) {
        this.areaCode = dto.getAreaCode();
        this.areaName = dto.getAreaName();
    }

    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL)
    private List<RackEntity> racks = new ArrayList<>();

}
