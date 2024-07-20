package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.InputWarehouseEntity;

@Repository

public interface InputWarehouseRepositoy extends JpaRepository<InputWarehouseEntity, Integer> {
    
    InputWarehouseEntity findByInputWarehouseNo(Integer inputWarehouseNo);

    List<InputWarehouseEntity> findByOrderByInputWarehouseNoDesc();
    
}
