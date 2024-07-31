package com.example.back.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.back.common.object.LotListItem;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.lot.GetLotResponseDto;
import com.example.back.dto.response.lot.GetLotSearchResponseDto;
import com.example.back.entity.LotEntity;
import com.example.back.repository.LotRepositoy;
import com.example.back.service.LotService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class LotServiceImplimentation implements LotService {
    
    @Autowired
    private final LotRepositoy lotRepositoy;

    @Override
    public ResponseEntity<? super GetLotResponseDto> getList() {

        try {
            List<LotEntity> lotEntities = lotRepositoy.findByOrderByLotNoDesc();
            return GetLotResponseDto.success(lotEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<ResponseDto> delete (int lotNo) {

        try {
            LotEntity lotEntity = lotRepositoy.findByLotNo(lotNo);
            if (lotEntity == null) return ResponseDto.noExistLot();

            lotRepositoy.delete(lotEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetLotSearchResponseDto> search (String search) {

        try {
            List<LotEntity> lotEntities;
            if (search == null || search.trim().isEmpty()) {
                lotEntities = lotRepositoy.findByOrderByLotNoDesc();
            } else {
                lotEntities = lotRepositoy.search(search);
            }

            List<LotListItem> lotListItems = LotListItem.getList(lotEntities);
            return GetLotSearchResponseDto.success(lotEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

}
