package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.back.dto.requset.department.PostDepartmentCreateRequestDto;
import com.example.back.dto.requset.department.PutDepartmentRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentNo;
    private String departmentCode;
    private String departmentName;

    public DepartmentEntity(PostDepartmentCreateRequestDto dto) {
        this.departmentCode = dto.getDepartmentCode();
        this.departmentName = dto.getDepartmentName();
    }

    public DepartmentEntity(PutDepartmentRequestDto dto) {
        this.departmentCode = dto.getDepartmentCode();
        this.departmentName = dto.getDepartmentName();
    }

}
