package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.back.entity.MemberEntity;

@Repository

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

    MemberEntity findByMemberNo(Integer memberNo);
    MemberEntity findByMemberId(String memberId);

    List<MemberEntity> findByOrderByMemberNoDesc();

    @Query("SELECT m FROM MemberEntity m "
        + "LEFT JOIN Department d "
        + "LEFT JOIN Rank r "
        + "WHERE "
        + "(m.memberId = :search OR :search IS NULL) OR "
        + "(m.memberName = :search OR :search IS NULL) OR "
        + "(d.departmentName = :search OR :search IS NULL) OR "
        + "(r.rankName = :search OR :search IS NULL) "
        + "ORDER BY m.memberNo DESC")
    List<MemberEntity> search(@Param("search") String search);
    
}