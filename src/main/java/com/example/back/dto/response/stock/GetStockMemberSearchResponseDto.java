package com.example.back.dto.response.stock;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.common.object.MemberListItem;
import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.MemberEntity;

import lombok.Getter;

@Getter

public class GetStockMemberSearchResponseDto extends ResponseDto  {

    private List<MemberListItem> memberList;

    private GetStockMemberSearchResponseDto(List<MemberEntity> memberEntities) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.memberList = MemberListItem.getList(memberEntities);
    }

    public static ResponseEntity<GetStockMemberSearchResponseDto> success(List<MemberEntity> memberEntities) throws Exception {

        GetStockMemberSearchResponseDto responseBody = new GetStockMemberSearchResponseDto(memberEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
