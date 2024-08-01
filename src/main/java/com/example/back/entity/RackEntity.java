package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.example.back.dto.requset.rack.PostRackCreateRequestDto;
import com.example.back.dto.requset.rack.PutRackRequestDto;
import com.example.back.dto.requset.stock.PostStockWarehouseAddRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="rack")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rackNo;
    private String rackCode;
    private String rackName;

    @ManyToOne
    @JoinColumn(name = "rack_area_no")
    private AreaEntity area;

    public RackEntity (PostRackCreateRequestDto dto) {
        this.rackCode = dto.getRackCode();
        this.rackName = dto.getRackName();
    }
    
    public void update (PutRackRequestDto dto) {
        this.rackCode = dto.getRackCode();
        this.rackName = dto.getRackName();
    }

    public RackEntity (PostStockWarehouseAddRequestDto dto) {
        this.rackName = dto.getRackName();
    }

}
