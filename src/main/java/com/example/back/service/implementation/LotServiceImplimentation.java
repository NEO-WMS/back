package com.example.back.service.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.lot.GetLotListResponseDto;
import com.example.back.dto.response.lot.GetLotSearchResponseDto;
import com.example.back.entity.LotEntity;
import com.example.back.repository.LotRepository;
import com.example.back.service.LotService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class LotServiceImplimentation implements LotService {
    
    private final LotRepository lotRepositoy;

    @Override
    public ResponseEntity<? super GetLotListResponseDto> getList() {

        try {
            List<LotEntity> lotEntities = lotRepositoy.findByOrderByLotNoDesc();
            return GetLotListResponseDto.success(lotEntities);
            
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
            
            if (search == null || search.trim().isEmpty()) {
                List<LotEntity> lotEntities = lotRepositoy.findByOrderByLotNoDesc();
                return GetLotSearchResponseDto.success(lotEntities);
            }

            List<LotEntity> lotEntities = lotRepositoy.search(search);
            return GetLotSearchResponseDto.success(lotEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

}
