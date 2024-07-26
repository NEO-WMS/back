package com.example.back.dto.response.member;

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

public class GetmemberSearchResponseDto extends ResponseDto {
    
    private List<MemberListItem> memberListItem;

    private GetmemberSearchResponseDto(List<MemberEntity> memberEntities) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.memberListItem = MemberListItem.getList(memberEntities);
    }

    public static ResponseEntity<GetmemberSearchResponseDto> success (List<MemberEntity> memberEntities) throws Exception {
        GetmemberSearchResponseDto responseBody = new GetmemberSearchResponseDto(memberEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
