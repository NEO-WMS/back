package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.back.entity.ClientEntity;

@Repository

public interface ClientRepositoy extends JpaRepository<ClientEntity, Integer> {
    
    ClientEntity findByClientNo(Integer clientNo);

    List<ClientEntity> findByOrderByClientNoDesc();

    List<ClientEntity> findByClientCategory(Integer clientCategory);

    @Query("SELECT c FROM ClientEntity c WHERE "
        + "(c.clientName = :search OR :search IS NULL) OR "
        + "(c.clientOwner = :search OR :search IS NULL) "
        + "ORDER BY c.clientNo DESC")
    List<ClientEntity> search(@Param("search") String search);
    
}
