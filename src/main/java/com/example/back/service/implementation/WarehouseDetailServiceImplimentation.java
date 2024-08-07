package com.example.back.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.back.common.util.LotCodeGenerator;
import com.example.back.dto.requset.warehouse.PostWarehouseCreateRequestDto;
import com.example.back.dto.requset.warehouseDetail.PostWarehouseDetailCreateRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.entity.AreaEntity;
import com.example.back.entity.CellEntity;
import com.example.back.entity.ItemEntity;
import com.example.back.entity.RackEntity;
import com.example.back.entity.WarehouseDetailEntity;
import com.example.back.entity.WarehouseEntity;
import com.example.back.repository.AreaRepository;
import com.example.back.repository.CellRepository;
import com.example.back.repository.ItemRepository;
import com.example.back.repository.RackRepository;
import com.example.back.repository.WarehouseDetailRepository;
import com.example.back.repository.WarehouseRepository;
import com.example.back.service.WarehouseDetailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class WarehouseDetailServiceImplimentation implements WarehouseDetailService {

    private final WarehouseRepository warehouseRepository;

    private final AreaRepository areaRepository;

    private final RackRepository rackRepository;

    private final CellRepository cellRepository;

    private final WarehouseDetailRepository warehouseDetailRepository;

    private final ItemRepository itemRepository;

    private final LotCodeGenerator lotCodeGenerator;

     @Override
    public ResponseEntity<ResponseDto> create(PostWarehouseDetailCreateRequestDto dto) {
        
        try {

            WarehouseEntity warehouse = warehouseRepository.findByWarehouseNo(null);
            AreaEntity area = areaRepository.findByAreaNo(null);
            RackEntity rack = rackRepository.findByRackNo(null);
            CellEntity cell = cellRepository.findByCellNo(null);
            ItemEntity item = itemRepository.findByItemNo(null);

            String lotCode = lotCodeGenerator.generateLotCode();

            WarehouseDetailEntity warehouseDetail = new WarehouseDetailEntity(dto, warehouse, area, rack, cell);
            warehouseDetail.setWarehouseDetailLotCode(lotCode);
            warehouseDetailRepository.save(warehouseDetail);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
    
}
