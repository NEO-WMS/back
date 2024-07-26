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

public class GetRankResponseDto extends ResponseDto {
    
    private List<RankListItem> rankListItem;

    private GetRankResponseDto(List<RankEntity> rankEntities) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.rankListItem = RankListItem.getList(rankEntities);
    }

    public static ResponseEntity<GetRankResponseDto> success(List<RankEntity> rankEntities) throws Exception {
        GetRankResponseDto responseBody = new GetRankResponseDto(rankEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
