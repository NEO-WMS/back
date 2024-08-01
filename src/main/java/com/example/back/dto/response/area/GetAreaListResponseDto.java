package com.example.back.dto.response.area;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.common.object.AreaListItem;
import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.AreaEntity;

import lombok.Getter;

@Getter

public class GetAreaListResponseDto extends ResponseDto {
    
    private List<AreaListItem> areaList;

    private GetAreaListResponseDto(List<AreaEntity> areaEntities) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.areaList = AreaListItem.getList(areaEntities);
    }

    public static ResponseEntity<GetAreaListResponseDto> success(List<AreaEntity> areaEntities) throws Exception {

        GetAreaListResponseDto responseBody = new GetAreaListResponseDto(areaEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
