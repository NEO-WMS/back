package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.ItemEntity;

@Repository

public interface ItemRepositoy extends JpaRepository<ItemEntity, Integer> {

    ItemEntity findByItemNo(Integer itemNo);

    List<ItemEntity> findByOrderByItemNoDesc();
    
}
