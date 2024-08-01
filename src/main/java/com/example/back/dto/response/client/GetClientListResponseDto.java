package com.example.back.dto.response.client;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.common.object.ClientListItem;
import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.ClientEntity;

import lombok.Getter;

@Getter

public class GetClientListResponseDto extends ResponseDto {
    
    private List<ClientListItem> clientList;

    private GetClientListResponseDto(List<ClientEntity> clientEntities) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.clientList = ClientListItem.getList(clientEntities);
    }

    public static ResponseEntity<GetClientListResponseDto> success(List<ClientEntity> clientEntities) throws Exception {
        GetClientListResponseDto responseBody = new GetClientListResponseDto(clientEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
