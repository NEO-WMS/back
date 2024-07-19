package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Member {

    @Id
    private Integer memberNo;
    private String memberId;
    private String memberPw;
    private String memberName;
    private Integer memberDepNo;
    private Integer memberRankNo;
    private String memberEmail;
    private String memberImage;
    private String memberRegDate;

}
