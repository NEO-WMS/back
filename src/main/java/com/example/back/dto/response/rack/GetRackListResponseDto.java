package com.example.back.dto.response.rack;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.common.object.RackListItem;
import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.RackEntity;

import lombok.Getter;

@Getter

public class GetRackListResponseDto extends ResponseDto {
    
    private List<RackListItem> rackList;

    private GetRackListResponseDto(List<RackEntity> rackEntities) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.rackList =RackListItem.getList(rackEntities);
    }

    public static ResponseEntity<GetRackListResponseDto> success(List<RackEntity> rackEntities) throws Exception {
        GetRackListResponseDto responseBody = new GetRackListResponseDto(rackEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
