package com.example.back.service.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.back.dto.requset.warehouse.PostWarehouseCreateRequestDto;
import com.example.back.dto.requset.warehouse.PutWarehouseRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.warehouse.GetWarehouseListResponseDto;
import com.example.back.dto.response.warehouse.GetWarehouseResponseDto;
import com.example.back.entity.WarehouseEntity;
import com.example.back.repository.WarehouseRepository;
import com.example.back.service.WarehouseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class WarehouseServiceImplimentation implements WarehouseService {
    
    private final WarehouseRepository warehouseRepositoy;

    @Override
    public ResponseEntity<ResponseDto> create(PostWarehouseCreateRequestDto dto) {

        try {
            WarehouseEntity warehouseEntity = new WarehouseEntity(dto);
            warehouseRepositoy.save(warehouseEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetWarehouseListResponseDto> getList() {

        try {
            List<WarehouseEntity> warehouseEntities = warehouseRepositoy.findByOrderByWarehouseNoDesc();
            return GetWarehouseListResponseDto.success(warehouseEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<ResponseDto> delete(int warehouseNo) {

        try {
            WarehouseEntity warehouseEntity = warehouseRepositoy.findByWarehouseNo(warehouseNo);
            if (warehouseEntity == null) return ResponseDto.noExistWarehouse();

            warehouseRepositoy.delete(warehouseEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> put(PutWarehouseRequestDto dto, int warehouseNo) {

        try {
            WarehouseEntity warehouseEntity = warehouseRepositoy.findByWarehouseNo(warehouseNo);
            if (warehouseEntity == null) return ResponseDto.noExistWarehouse();

            warehouseEntity.update(dto);
            warehouseRepositoy.save(warehouseEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetWarehouseResponseDto> getWarehouse(int warehouseNo) {

        try {
            WarehouseEntity warehouseEntity = warehouseRepositoy.findByWarehouseNo(warehouseNo);
            if (warehouseEntity == null) return ResponseDto.noExistWarehouse();

            return GetWarehouseResponseDto.success(warehouseEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
}
