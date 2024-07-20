package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.ItemMovementHistoryEntity;

@Repository

public interface ItemMovementHistoryRepositoy extends JpaRepository<ItemMovementHistoryEntity, Integer> {

    ItemMovementHistoryEntity findByItemMovementHistoryNo(Integer itemMovementHistoryNo);

    List<ItemMovementHistoryEntity> findByOrderByItemMovementHistoryNoDesc();
    
}
