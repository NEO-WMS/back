package com.example.back.service.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.back.dto.requset.rank.PostRankCreateRequestDto;
import com.example.back.dto.requset.rank.PutRankRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.rank.GetRankListResponseDto;
import com.example.back.dto.response.rank.GetRankSearchResponseDto;
import com.example.back.entity.RankEntity;
import com.example.back.repository.RankRepositoy;
import com.example.back.service.RankService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class RankServiceImplimentation implements RankService {
    
    private final RankRepositoy rankRepositoy;

    @Override
    public ResponseEntity<ResponseDto> create(PostRankCreateRequestDto dto) {

        try {
            
            RankEntity rankEntity = new RankEntity(dto);
            rankRepositoy.save(rankEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetRankListResponseDto> getList() {
        
        try {
            List<RankEntity> rankEntities = rankRepositoy.findByOrderByRankNoDesc();
            return GetRankListResponseDto.success(rankEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    } 

    @Override
    public ResponseEntity<ResponseDto> delete(int rankNo) {

        try {
            RankEntity rankEntity = rankRepositoy.findByRankNo(rankNo);
            if (rankEntity == null) return ResponseDto.noExistRank();

            rankRepositoy.delete(rankEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> put(PutRankRequestDto dto, int rankNo) {

        try {
            RankEntity rankEntity = rankRepositoy.findByRankNo(rankNo);
            if (rankEntity == null) return ResponseDto.noExistRank();

            rankEntity.update(dto);
            rankRepositoy.save(rankEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetRankSearchResponseDto> search(String search) {

        try {
            if (search == null || search.trim().isEmpty()) {
                List<RankEntity> rankEntities = rankRepositoy.findByOrderByRankNoDesc();
                return GetRankSearchResponseDto.success(rankEntities);
            }

            List<RankEntity> rankEntities = rankRepositoy.search(search);
            return GetRankSearchResponseDto.success(rankEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
}
