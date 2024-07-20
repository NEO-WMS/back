package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.PurchaseSheetDetailEntity;

@Repository

public interface PurchaseSheetDetailRepositoy extends JpaRepository<PurchaseSheetDetailEntity, Integer> {

    PurchaseSheetDetailEntity findByPurchaseSheetDetailNo(Integer purchaseSheetDetailNo);

    List<PurchaseSheetDetailEntity> findByOrderByPurchaseSheetDetailNoDesc();
    
}
