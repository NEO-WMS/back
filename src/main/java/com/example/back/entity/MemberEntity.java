package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.example.back.common.util.ChangeDateFormatUtil;
import com.example.back.dto.requset.auth.AuthSignInRequestDto;
import com.example.back.dto.requset.member.PostMemberCreateRequestDto;
import com.example.back.dto.requset.member.PutMemberRequestDto;
import com.example.back.dto.requset.stock.PostStockMemberAddRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

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

public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberNo;

    private String memberId;
    private String memberPw;
    private String memberName;
    private Integer memberDepNo;
    private Integer memberRankNo;
    private String memberEmail;
    private String memberImage;
    private String memberRegDate;
    private String memberRole;

    // @ManyToOne
    // @JoinColumn(name = "member_dep_no")
    // private DepartmentEntity department;

    // @ManyToOne
    // @JoinColumn(name = "member_rank_no")
    // private RankEntity rank;

    public MemberEntity(AuthSignInRequestDto dto) {
        this.memberId = dto.getMemberId();
        this.memberPw = dto.getMemberPw();
    }

    public MemberEntity(PostMemberCreateRequestDto dto) {
        this.memberId = dto.getMemberId();
        this.memberPw = dto.getMemberPw();
        this.memberName = dto.getMemberName();
        this.memberDepNo = dto.getMemberDepNo();
        this.memberRankNo = dto.getMemberRankNo();
        this.memberEmail = dto.getMemberEmail();
        this.memberImage = dto.getMemberImage();
        this.memberRegDate = ChangeDateFormatUtil.getCurrentDatetiem();
        this.memberRole = "ROLE_USER";
    }

    public void update(PutMemberRequestDto dto) {
        this.memberName = dto.getMemberName();
        this.memberDepNo = dto.getMemberDepNo();
        this.memberRankNo = dto.getMemberRankNo();
        this.memberEmail = dto.getMemberEmail();
        this.memberImage = dto.getMemberImage();
    }

    public MemberEntity(PostStockMemberAddRequestDto dto) {
        this.memberName = dto.getMemberName();
    }
}