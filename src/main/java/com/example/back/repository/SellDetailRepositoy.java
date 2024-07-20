package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.SellDetailEntity;

@Repository

public interface SellDetailRepositoy extends JpaRepository<SellDetailEntity, Integer> {

    SellDetailEntity findBySellDetailNo(Integer sellDetailNo);

    List<SellDetailEntity> findByOrderBySellDetailNoDesc();
    
}
