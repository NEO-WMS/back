package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.OrderSheetEntity;

@Repository

public interface OrderSheetRepositoy extends JpaRepository<OrderSheetEntity, Integer> {

    OrderSheetEntity findByOrderSheetNo(Integer orderSheetNo);

    List<OrderSheetEntity> findByOrderByOrderSheetNoDesc();
    
}