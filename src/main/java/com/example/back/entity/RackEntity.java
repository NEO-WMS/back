package com.example.back.entity;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.example.back.dto.requset.rack.PostRackCreateRequestDto;
import com.example.back.dto.requset.rack.PutRackRequestDto;

import jakarta.persistence.CascadeType;
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

    @OneToMany(mappedBy = "rack", cascade = CascadeType.ALL)
    private List<CellEntity> cells = new ArrayList<>();

}
