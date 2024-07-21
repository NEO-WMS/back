package com.example.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.MemberEntity;

@Repository

public interface MemberRepositoy extends JpaRepository<MemberEntity, Integer> {

    MemberEntity findByMemberNo(Integer memberNo);
    MemberEntity findByMemberId(String memberId);

    List<MemberEntity> findByOrderByMemberNoDesc();
    
}