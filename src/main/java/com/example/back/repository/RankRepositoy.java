package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.RankEntity;

@Repository

public interface RankRepositoy extends JpaRepository<RankEntity, Integer> {

    RankEntity findByRankNo(Integer rankNo);

    List<RankEntity> findByOrderByRankNoDesc();
    
}