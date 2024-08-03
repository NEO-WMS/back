package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.InputWarehouseDetailEntity;

@Repository

public interface InputWarehouseDetailRepository extends JpaRepository<InputWarehouseDetailEntity, Integer> {

    InputWarehouseDetailEntity findByInputWarehouseDetailNo(Integer inputWarehouseDetailNo);

    List<InputWarehouseDetailEntity> findByOrderByInputWarehouseDetailNoDesc();
    
}
