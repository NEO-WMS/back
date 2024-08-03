package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.SellEntity;

@Repository

public interface SellRepository extends JpaRepository<SellEntity, Integer> {

    SellEntity findBySellNo(Integer sellNo);

    List<SellEntity> findByOrderBySellNoDesc();
    
}
