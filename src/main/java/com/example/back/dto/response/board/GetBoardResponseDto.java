package com.example.back.dto.response.board;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.BoardEntity;

import lombok.Getter;

@Getter

public class GetBoardResponseDto extends ResponseDto {

    private Integer boardNo;
    private String boardTitle;
    private String boardContext;

    private GetBoardResponseDto(BoardEntity boardEntity) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.boardNo = boardEntity.getBoardNo();
        this.boardTitle = boardEntity.getBoardTitle();
        this.boardContext = boardEntity.getBoardContent();
    }

    public static ResponseEntity<GetBoardResponseDto> success(BoardEntity boardEntities) throws Exception {

        GetBoardResponseDto responseBody = new GetBoardResponseDto(boardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
