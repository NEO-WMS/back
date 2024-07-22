package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.CellEntity;

@Repository

public interface CellRepository extends JpaRepository<CellEntity, Integer> {
    
    CellEntity findByCellNo(Integer cellNo);

    List<CellEntity> findByOrderByCellNoDesc();

}
