package com.example.back.dto.response.stock;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.MemberEntity;

import lombok.Getter;

@Getter

public class GetStockMemberResponseDto extends ResponseDto {
    
    private Integer memberNo;
    private String memberName;

    private GetStockMemberResponseDto(MemberEntity memberEntity) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.memberNo = memberEntity.getMemberNo();
        this.memberName = memberEntity.getMemberName();
    }

    public static ResponseEntity<GetStockMemberResponseDto> success(MemberEntity memberEntity) throws Exception {

        GetStockMemberResponseDto responseBody = new GetStockMemberResponseDto(memberEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
