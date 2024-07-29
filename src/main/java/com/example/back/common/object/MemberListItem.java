package com.example.back.common.object;

import java.util.List;

import com.example.back.entity.MemberEntity;

import java.util.ArrayList;

import lombok.Getter;

@Getter

public class MemberListItem {

    private Integer memberNo;
    private String memberId;
    private String memberName;
    private Integer memberDepNo;
    private Integer memberRankNo;
    private String memberEmail;
    private String memberImage;
    private String memberRegDate;

    private MemberListItem(MemberEntity memberEntity) throws Exception {
        this.memberNo = memberEntity.getMemberNo();
        this.memberId = memberEntity.getMemberId();
        this.memberName = memberEntity.getMemberName();
        this.memberDepNo = memberEntity.getMemberDepNo();
        this.memberRankNo = memberEntity.getMemberRankNo();
        this.memberEmail = memberEntity.getMemberEmail();
        this.memberImage = memberEntity.getMemberImage();
        this.memberRegDate = memberEntity.getMemberRegDate();
    }

    public static List<MemberListItem> getList(List<MemberEntity> memberEntities) throws Exception {
        List<MemberListItem> memberList = new ArrayList<>();

        for (MemberEntity memberEntity: memberEntities) {
            MemberListItem memberListItem = new MemberListItem(memberEntity);
            memberList.add(memberListItem);
        }
        return memberList;
    }
}
