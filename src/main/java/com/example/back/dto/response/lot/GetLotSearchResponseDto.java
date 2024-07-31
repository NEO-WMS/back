package com.example.back.dto.response.lot;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.common.object.LotListItem;
import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.LotEntity;

import lombok.Getter;

@Getter

public class GetLotSearchResponseDto extends ResponseDto {

    private List<LotListItem> lotList;

    private GetLotSearchResponseDto(List<LotEntity> lotEntities) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.lotList = LotListItem.getList(lotEntities);
    }

    public static ResponseEntity<GetLotSearchResponseDto> success (List<LotEntity> lotEntities) throws Exception {
        GetLotSearchResponseDto responseBody = new GetLotSearchResponseDto(lotEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
