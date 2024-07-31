package com.example.back.dto.response.client;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.common.object.ClientListItem;
import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import lombok.Getter;

@Getter

public class GetClientSearchResponseDto extends ResponseDto {
    
    private List<ClientListItem> clientList;

    private GetClientSearchResponseDto(List<ClientListItem> clientListItem) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.clientList = clientListItem;
    }

    public static ResponseEntity<GetClientSearchResponseDto> success(List<ClientListItem> clientListItem) throws Exception {
        GetClientSearchResponseDto responseBody = new GetClientSearchResponseDto(clientListItem);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
