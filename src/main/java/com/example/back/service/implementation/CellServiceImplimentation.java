package com.example.back.service.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.back.dto.requset.cell.PostCellCreateRequestDto;
import com.example.back.dto.requset.cell.PutCellRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.cell.GetCellListResponseDto;
import com.example.back.dto.response.cell.GetCellResponseDto;
import com.example.back.entity.CellEntity;
import com.example.back.repository.CellRepository;
import com.example.back.service.CellService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CellServiceImplimentation implements CellService {
    
    private final CellRepository cellRepository;

    @Override
    public ResponseEntity<ResponseDto> create(PostCellCreateRequestDto dto) {

        try {
            CellEntity cellEntity = new CellEntity(dto);
            cellRepository.save(cellEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetCellListResponseDto> getList() {

        try {
            List<CellEntity> cellEntities = cellRepository.findByOrderByCellNoDesc();
            return GetCellListResponseDto.success(cellEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<ResponseDto> delete(int cellNo) {

        try {
            CellEntity cellEntity = cellRepository.findByCellNo(cellNo);
            if (cellEntity == null) return ResponseDto.noExistCell();

            cellRepository.delete(cellEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> put(PutCellRequestDto dto, int cellNo) {

        try {
            CellEntity cellEntity = cellRepository.findByCellNo(cellNo);
            if (cellEntity == null) return ResponseDto.noExistCell();

            cellEntity.update(dto);
            cellRepository.save(cellEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetCellResponseDto> getCell(int cellNo) {

        try {
            CellEntity cellEntity = cellRepository.findByCellNo(cellNo);
            if (cellEntity == null) return ResponseDto.noExistCell();

            return GetCellResponseDto.success(cellEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
}
