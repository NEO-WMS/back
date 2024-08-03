package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.back.entity.LotEntity;

@Repository

public interface LotRepository extends JpaRepository<LotEntity, Integer> {

    LotEntity findByLotNo(Integer lotNo);

    List<LotEntity> findByOrderByLotNoDesc();

    @Query("SELECT l FROM LotEntity l "
        + "LEFT JOIN ItemEntity i "
        + "WHERE "
        + "(l.lotCode = :search OR :search IS NULL ) OR"
        + "(i.itemCode = :search OR :search IS NULL ) OR"
        + "(i.itemName = :search OR :search IS NULL) "
        + "ORDER BY l.lotNo DESC")
    List<LotEntity> search(@Param("search") String search);

}