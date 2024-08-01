package com.example.back.dto.response.rack;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.RackEntity;

import lombok.Getter;

@Getter

public class GetRackResponseDto extends ResponseDto {
    
    private Integer rackNo;
    private String rackCode;
    private String rackName;
    private String rackAreaName;

    private GetRackResponseDto(RackEntity rackEntity) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.rackNo = rackEntity.getRackNo();
        this.rackCode = rackEntity.getRackCode();
        this.rackName = rackEntity.getRackName();
        this.rackAreaName = rackEntity.getArea().getAreaName();
    }

    public static ResponseEntity<GetRackResponseDto> success(RackEntity rackEntity) throws Exception {

        GetRackResponseDto responseBody = new GetRackResponseDto(rackEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
