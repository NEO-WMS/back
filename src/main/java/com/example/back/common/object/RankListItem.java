package com.example.back.common.object;

import java.util.List;
import java.util.ArrayList;

import com.example.back.entity.RankEntity;

import lombok.Getter;

@Getter

public class RankListItem {
    
    private Integer rankNo;
    private String rankCode;
    private String rankName;

    private RankListItem(RankEntity rankEntity) throws Exception {
        this.rankNo = rankEntity.getRankNo();
        this.rankCode = rankEntity.getRankCode();
        this.rankName = rankEntity.getRankName();
    }

    public static List<RankListItem> getList (List<RankEntity> rankEntities) throws Exception {
        List<RankListItem> rankList = new ArrayList<>();

        for (RankEntity rankEntity: rankEntities) {
            RankListItem rankListItem = new RankListItem(rankEntity);
            rankList.add(rankListItem);
        }
        return rankList;
    }

}
