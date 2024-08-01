package com.example.back.dto.response.cell;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.dto.response.ResponseCode;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.ResponseMessage;
import com.example.back.entity.CellEntity;

import lombok.Getter;

@Getter

public class GetCellResponseDto extends ResponseDto {

    private Integer cellNo;
    private String cellCode;
    private String cellName;
    private String cellRackName;

    private GetCellResponseDto(CellEntity cellEntity) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.cellNo = cellEntity.getCellNo();
        this.cellCode = cellEntity.getCellCode();
        this.cellName = cellEntity.getCellName();
        this.cellRackName = cellEntity.getRack().getRackName();
    }

    public static ResponseEntity<GetCellResponseDto> success(CellEntity cellEntity) throws Exception {

        GetCellResponseDto responseBody = new GetCellResponseDto(cellEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
