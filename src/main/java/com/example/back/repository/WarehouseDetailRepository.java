package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.WarehouseDetailEntity;

@Repository

public interface WarehouseDetailRepository extends JpaRepository<WarehouseDetailEntity, Integer> {

    WarehouseDetailEntity findByWarehouseDetailNo(Integer warehouseDetailNo);

    List<WarehouseDetailEntity> findByOrderByWarehouseDetailNoDesc();
    
}