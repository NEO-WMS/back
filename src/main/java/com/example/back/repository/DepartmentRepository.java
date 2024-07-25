package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.back.entity.DepartmentEntity;

@Repository

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
    
    DepartmentEntity findByDepartmentNo(Integer departmentNo);

    List<DepartmentEntity> findByOrderByDepartmentNoDesc();

    @Query("SELECT d FROM DepartmentEntity d WHERE "
        + "(d.departmentCode = :searchTerm OR :searchTerm IS NULL) OR "
        + "(d.departmentName = :searchTerm OR :searchTerm IS NULL) "
        + "ORDER BY d.departmentNo DESC")
    List<DepartmentEntity> search(
    @Param("searchTerm") String searchWord);
    
}
