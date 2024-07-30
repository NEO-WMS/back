package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import com.example.back.common.util.ChangeDateFormatUtil;
import com.example.back.dto.requset.auth.AuthSignInRequestDto;
import com.example.back.dto.requset.member.PutMemberRequestDto;
import com.example.back.dto.requset.member.PostMemberCreateRequestDto;
import com.example.back.dto.requset.stock.PostStockMemberAddRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="member", uniqueConstraints = {@UniqueConstraint(columnNames = "memberId")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberNo;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_pw")
    private String memberPw;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_dep_no")
    private Integer memberDepNo;

    @Column(name = "member_rank_no")
    private Integer memberRankNo;

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "member_image")
    private String memberImage;

    @Column(name = "member_reg_date")
    private String memberRegDate;

    @Column(name = "member_role")
    private String memberRole;

    @ManyToOne
    @JoinColumn(name = "member_dep_no", insertable = false, updatable = false)
    private DepartmentEntity department;

    @ManyToOne
    @JoinColumn(name = "member_rank_no", insertable = false, updatable = false)
    private RankEntity rank;
    
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