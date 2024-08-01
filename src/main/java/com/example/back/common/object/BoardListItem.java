package com.example.back.common.object;

import java.util.List;
import java.util.ArrayList;

import com.example.back.entity.BoardEntity;

import lombok.Getter;

@Getter

public class BoardListItem {
    
    private Integer boardNo;
    private String boardTitle;
    private String boardContent;
    private String boardDate;

    private BoardListItem(BoardEntity boardEntity) throws Exception {
        this.boardNo = boardEntity.getBoardNo();
        this.boardTitle = boardEntity.getBoardTitle();
        this.boardContent = boardEntity.getBoardContent();
        this.boardDate = boardEntity.getBoardDate();
    }

    public static List<BoardListItem> getList(List<BoardEntity> boardEntities) throws Exception {

        List<BoardListItem> boardList = new ArrayList<>();
        for (BoardEntity boardEntity: boardEntities) {
            BoardListItem boardListItem = new BoardListItem(boardEntity);
            boardList.add(boardListItem);
        }
        return boardList;
    }

}
