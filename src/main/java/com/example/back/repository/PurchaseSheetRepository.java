package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.PurchaseSheetEntity;

@Repository

public interface PurchaseSheetRepository extends JpaRepository<PurchaseSheetEntity, Integer> {

    PurchaseSheetEntity findByPurchaseSheetNo(Integer purchaseSheetNo);

    List<PurchaseSheetEntity> findByOrderByPurchaseSheetNoDesc();
    
}