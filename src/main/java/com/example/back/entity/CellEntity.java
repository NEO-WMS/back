package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.example.back.dto.requset.cell.PostCellCreateRequestDto;
import com.example.back.dto.requset.cell.PutCellRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="cell")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CellEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cellNo;
    private String cellCode;
    private String cellName;

    @ManyToOne
    @JoinColumn(name = "cell_rack_no")
    private RackEntity rack;

    public CellEntity (PostCellCreateRequestDto dto) {
        this.cellCode = dto.getCellCode();
        this.cellName = dto.getCellName();
    }

    public void update (PutCellRequestDto dto) {
        this.cellCode = dto.getCellCode();
        this.cellName = dto.getCellName();
    }

}
