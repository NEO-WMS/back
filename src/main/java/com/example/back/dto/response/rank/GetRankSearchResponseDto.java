package com.example.back.dto.response.rank;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.common.object.RankListItem;
import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.RankEntity;

import lombok.Getter;

@Getter

public class GetRankSearchResponseDto extends ResponseDto {
    
    private List<RankListItem> rankList;

    private GetRankSearchResponseDto(List<RankEntity> rankEntities) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.rankList = RankListItem.getList(rankEntities);
    }

    public static ResponseEntity<GetRankSearchResponseDto> success(List<RankEntity> rankEntities) throws Exception {
        GetRankSearchResponseDto responseBody = new GetRankSearchResponseDto(rankEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
