package com.example.back.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.common.object.BoardListItem;
import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.BoardEntity;

import lombok.Getter;

@Getter

public class GetBoardListResponseDto extends ResponseDto {
    
    private List<BoardListItem> boardList;

    private GetBoardListResponseDto(List<BoardEntity> boardEntities) throws Exception {
        
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.boardList = BoardListItem.getList(boardEntities);
    }

    public static ResponseEntity<GetBoardListResponseDto> success(List<BoardEntity> boardEntities) throws Exception {
        GetBoardListResponseDto responseBody = new GetBoardListResponseDto(boardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
