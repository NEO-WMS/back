package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.RackEntity;

@Repository

public interface RackRepositoy extends JpaRepository<RackEntity, Integer> {

    RackEntity findByRackNo(Integer rackNo);

    List<RackEntity> findByOrderByRackNoDesc();
    
}