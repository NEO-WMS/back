package com.example.back.common.object;

import java.util.List;
import java.util.ArrayList;

import com.example.back.entity.MemberEntity;

import lombok.Getter;

@Getter
public class MemberListItem {

    private Integer memberNo;
    private String memberId;
    private String memberName;
    private String departmentName;
    private String rankName;
    private String memberEmail;
    private String memberImage;
    private String memberRegDate;

    private MemberListItem(MemberEntity memberEntity) throws Exception {
        this.memberNo = memberEntity.getMemberNo();
        this.memberId = memberEntity.getMemberId();
        this.memberName = memberEntity.getMemberName();
        this.departmentName = memberEntity.getDepartment().getDepartmentName();
        this.rankName = memberEntity.getRank().getRankName();
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

