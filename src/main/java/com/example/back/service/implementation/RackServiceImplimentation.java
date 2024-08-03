package com.example.back.service.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.back.dto.requset.rack.PostRackCreateRequestDto;
import com.example.back.dto.requset.rack.PutRackRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.rack.GetRackListResponseDto;
import com.example.back.dto.response.rack.GetRackResponseDto;
import com.example.back.entity.RackEntity;
import com.example.back.repository.RackRepository;
import com.example.back.service.RackService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class RackServiceImplimentation implements RackService {

    private final RackRepository rackRepositoy;

    @Override
    public ResponseEntity<ResponseDto> create(PostRackCreateRequestDto dto) {

        try {
            RackEntity rackEntity = new RackEntity(dto);
            rackRepositoy.save(rackEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetRackListResponseDto> getList() {

        try {
            List<RackEntity> rackEntities = rackRepositoy.findByOrderByRackNoDesc();
            return GetRackListResponseDto.success(rackEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<ResponseDto> delete(int rackNo) {

        try {
            RackEntity rackEntity = rackRepositoy.findByRackNo(rackNo);
            if (rackEntity == null) return ResponseDto.noExistRack();

            rackRepositoy.delete(rackEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> put(PutRackRequestDto dto, int rackNo) {

        try {
            RackEntity rackEntity = rackRepositoy.findByRackNo(rackNo);
            if (rackEntity == null) return ResponseDto.noExistRack();

            rackEntity.update(dto);
            rackRepositoy.save(rackEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetRackResponseDto> getRack(int rackNo) {

        try {
            RackEntity rackEntity = rackRepositoy.findByRackNo(rackNo);
            if (rackEntity == null) return ResponseDto.noExistRack();

            return GetRackResponseDto.success(rackEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
    
}
