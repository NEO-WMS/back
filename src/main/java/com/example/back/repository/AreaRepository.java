package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.AreaEntity;

@Repository

public interface AreaRepository extends JpaRepository<AreaEntity, Integer> {
    
    AreaEntity findByAreaNo(Integer areaNo);

    List<AreaEntity> findByOrderByAreaNoDesc();

}
