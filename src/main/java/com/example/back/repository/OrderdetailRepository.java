package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.OrderDetailEntity;

@Repository

public interface OrderdetailRepository extends JpaRepository<OrderDetailEntity, Integer> {

    OrderDetailEntity findByOrderDetailNo(Integer orderDetailNo);

    List<OrderDetailEntity> findByOrderByOrderDetailNoDesc();
    
}