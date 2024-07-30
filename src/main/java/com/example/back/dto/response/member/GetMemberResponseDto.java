package com.example.back.dto.response.member;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.common.object.MemberListItem;
import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetMemberResponseDto extends ResponseDto {
    
    private List<MemberListItem> memberListItem;

    private GetMemberResponseDto(List<MemberListItem> memberListItem) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.memberListItem = memberListItem;
    }

    public static ResponseEntity<GetMemberResponseDto> success(List<MemberListItem> memberListItem) {
        GetMemberResponseDto responseBody = new GetMemberResponseDto(memberListItem);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody); 
    }
}
