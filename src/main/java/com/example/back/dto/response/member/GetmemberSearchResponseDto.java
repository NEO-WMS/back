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
public class GetmemberSearchResponseDto extends ResponseDto {
    
    private List<MemberListItem> memberListItem;

    private GetmemberSearchResponseDto(List<MemberListItem> memberListItem) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.memberListItem = memberListItem;
    }

    public static ResponseEntity<GetmemberSearchResponseDto> success(List<MemberListItem> memberListItem) throws Exception {
        GetmemberSearchResponseDto responseBody = new GetmemberSearchResponseDto(memberListItem);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody); 
    }
}
