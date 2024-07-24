package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.back.dto.requset.rank.PostRankCreateRequestDto;
import com.example.back.dto.requset.rank.PutRankRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="rank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rankNo;
    private String rankCode;
    private String rankName;

    public RankEntity(PostRankCreateRequestDto dto) {
        this.rankCode = dto.getRankCode();
        this.rankName = dto.getRankName();
    }

    public RankEntity(PutRankRequestDto dto) {
        this.rankCode = dto.getRankCode();
        this.rankName = dto.getRankName();
    }

}