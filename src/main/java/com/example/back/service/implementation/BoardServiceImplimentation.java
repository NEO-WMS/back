package com.example.back.service.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.back.dto.requset.board.PostBoardCreateRequestDto;
import com.example.back.dto.requset.board.PutBoardRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.board.GetBoardListResponseDto;
import com.example.back.dto.response.board.GetBoardResponseDto;
import com.example.back.entity.BoardEntity;
import com.example.back.repository.BoardRepository;
import com.example.back.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BoardServiceImplimentation implements BoardService {
    
    private final BoardRepository boardRepository;

    @Override
    public ResponseEntity<ResponseDto> create(PostBoardCreateRequestDto dto) {

        try {
            BoardEntity boardEntity = new BoardEntity(dto);
            boardRepository.save(boardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getList() {

        try {
            List<BoardEntity> boardEntities = boardRepository.findByOrderByBoardNoDesc();
            return GetBoardListResponseDto.success(boardEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<ResponseDto> delete(int boardNo) {

        try {
            BoardEntity boardEntity = boardRepository.findByBoardNo(boardNo);
            if (boardEntity == null) return ResponseDto.noExistBoard();

            boardRepository.delete(boardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> put(PutBoardRequestDto dto, int boardNo) {

        try {
            BoardEntity boardEntity = boardRepository.findByBoardNo(boardNo);
            if (boardEntity == null) return ResponseDto.noExistBoard();

            boardEntity.update(dto);
            boardRepository.save(boardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(int boardNo) {

        try {
            BoardEntity boardEntity = boardRepository.findByBoardNo(boardNo);
            if (boardEntity == null) return ResponseDto.noExistBoard();

            return GetBoardResponseDto.success(boardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

}
