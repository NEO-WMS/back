package com.example.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.back.entity.BoardEntity;

@Repository

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    
    BoardEntity findByBoardNo(Integer boardNo);

    List<BoardEntity> findByOrderByBoardNoDesc();

}
