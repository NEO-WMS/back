package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.DepartmentEntity;

@Repository

public interface DepartmentRepositoy extends JpaRepository<DepartmentEntity, Integer> {
    
    DepartmentEntity findByDepartmentNo(Integer departmentNo);

    List<DepartmentEntity> findByOrderByDepartmentNoDesc();
    
}
