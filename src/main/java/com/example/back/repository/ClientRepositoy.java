package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.ClientEntity;

@Repository

public interface ClientRepositoy extends JpaRepository<ClientEntity, Integer> {
    
    ClientEntity findByClientNo(Integer clientNo);

    List<ClientEntity> findByOrderByClientDesc();
    
}
