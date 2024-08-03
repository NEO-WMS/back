package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.back.entity.ItemEntity;

@Repository

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

    ItemEntity findByItemNo(Integer itemNo);

    List<ItemEntity> findByOrderByItemNoDesc();

    @Query("SELECT i FROM ItemEntity i "
        + "LEFT JOIN ClientEntity c "
        + "WHERE "
        + "(i.itemName = :search OR :search IS NULL) OR "
        + "(c.clientName = :search OR :search IS NULL) "
        + "ORDER BY i.itemNo DESC")
    List<ItemEntity> search(@Param("search") String search);
    
}
