package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.WarehouseEntity;

@Repository

public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Integer> {

    WarehouseEntity findByWarehouseNo(Integer warehouseNo);

    List<WarehouseEntity> findByOrderByWarehouseNoDesc();

    List<WarehouseEntity> findAll();
    
}
