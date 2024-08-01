package com.example.back.dto.response.cell;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.common.object.CellListItem;
import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.CellEntity;

import lombok.Getter;

@Getter

public class GetCellListResponseDto extends ResponseDto {
    
    private List<CellListItem> cellList;

    private GetCellListResponseDto(List<CellEntity> cellEntities) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.cellList = CellListItem.getList(cellEntities);
    }

    public static ResponseEntity<GetCellListResponseDto> success(List<CellEntity> cellEntities) throws Exception {

        GetCellListResponseDto responseBody = new GetCellListResponseDto(cellEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
