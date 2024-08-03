package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.back.entity.RankEntity;

@Repository

public interface RankRepository extends JpaRepository<RankEntity, Integer> {

    RankEntity findByRankNo(Integer rankNo);

    List<RankEntity> findByOrderByRankNoDesc();

    @Query("SELECT r FROM RankEntity r WHERE "
        + "(r.rankCode = :search OR :search IS NULL ) OR "
        + "(r.rankName = :search OR :search IS NULL ) "
        + "ORDER BY r.rankNo DESC")
    List<RankEntity> search(@Param("search") String search);
    
}