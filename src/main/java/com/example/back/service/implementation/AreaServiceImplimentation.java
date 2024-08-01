package com.example.back.service.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.back.dto.requset.area.PostAreaCreateRequestDto;
import com.example.back.dto.requset.area.PutAreaRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.area.GetAreaListResponseDto;
import com.example.back.dto.response.area.GetAreaResponseDto;
import com.example.back.entity.AreaEntity;
import com.example.back.repository.AreaRepository;
import com.example.back.service.AreaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AreaServiceImplimentation implements AreaService {

    private AreaRepository areaRepository;

    @Override
    public ResponseEntity<ResponseDto> create(PostAreaCreateRequestDto dto) {

        try {
            AreaEntity areaEntity = new AreaEntity(dto);
            areaRepository.save(areaEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetAreaListResponseDto> getList() {

        try {
            List<AreaEntity> areaEntity = areaRepository.findByOrderByAreaNoDesc();
            return GetAreaListResponseDto.success(areaEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<ResponseDto> delete(int areaNo) {

        try {
            AreaEntity areaEntity = areaRepository.findByAreaNo(areaNo);
            if (areaEntity == null) return ResponseDto.noExistArea();

            areaRepository.delete(areaEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> put(PutAreaRequestDto dto, int areaNo) {

        try {
            AreaEntity areaEntity = areaRepository.findByAreaNo(areaNo);
            if (areaEntity == null) return ResponseDto.noExistArea();

            areaEntity.update(dto);
            areaRepository.save(areaEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetAreaResponseDto> getArea(int areaNo) {

        try {
            AreaEntity areaEntity = areaRepository.findByAreaNo(areaNo);
            if (areaEntity == null) return ResponseDto.noExistArea();

            return GetAreaResponseDto.success(areaEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
    
}
