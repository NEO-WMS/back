package com.example.back.entity;

import com.example.back.common.util.ChangeDateFormatUtil;
import com.example.back.dto.requset.board.PostBoardCreateRequestDto;
import com.example.back.dto.requset.board.PutBoardRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardNo;

    private String boardTitle;
    private String boardContent;
    private String boardDate;

    public BoardEntity(PostBoardCreateRequestDto dto) {
        this.boardTitle = dto.getBoardTitle();
        this.boardContent = dto.getBoardContent();
        this.boardDate = ChangeDateFormatUtil.getCurrentDate();
    }

    public void update(PutBoardRequestDto dto) {
        this.boardTitle = dto.getBoardTitle();
        this.boardContent = dto.getBoardContent();
    }

}
