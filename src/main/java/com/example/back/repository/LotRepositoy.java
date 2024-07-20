package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.LotEntity;

@Repository

public interface LotRepositoy extends JpaRepository<LotEntity, Integer> {

    LotEntity findByLotNo(Integer lotNo);

    List<LotEntity> findByOrderByLotNoDesc();
    
}
