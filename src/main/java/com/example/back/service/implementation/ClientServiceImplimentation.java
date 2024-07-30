package com.example.back.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.back.dto.requset.client.PostClientCreateRequestDto;
import com.example.back.dto.requset.client.PutClientRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.client.GetClientResponseDto;
import com.example.back.dto.response.client.GetClientSearchResponseDto;
import com.example.back.entity.ClientEntity;
import com.example.back.repository.ClientRepositoy;
import com.example.back.service.ClientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ClientServiceImplimentation implements ClientService {
    
    @Autowired
    private final ClientRepositoy clientRepositoy;

    @Override
    public ResponseEntity<ResponseDto> create(PostClientCreateRequestDto dto) {

        try {
            ClientEntity clientEntity = new ClientEntity(dto);
            clientRepositoy.save(clientEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetClientResponseDto> getList() {

        try {
            List<ClientEntity> clientEntities = clientRepositoy.findByOrderByClientNoDesc();
            return GetClientResponseDto.success(clientEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<ResponseDto> delete(int clientNo) {

        try {
            ClientEntity clientEntity = clientRepositoy.findByClientNo(clientNo);
            if (clientEntity == null) return ResponseDto.noExistClient();

            clientRepositoy.delete(clientEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> put(PutClientRequestDto dto, int clientNo) {

        try {
            ClientEntity clientEntity = clientRepositoy.findByClientNo(clientNo);
            if (clientEntity == null) return ResponseDto.noExistClient();

            clientEntity.update(dto);
            clientRepositoy.save(clientEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetClientSearchResponseDto> search(String search) {

        try {
            if (search == null || search.trim().isEmpty()) {
                List<ClientEntity> clientEntities = clientRepositoy.findByOrderByClientNoDesc();
                return GetClientSearchResponseDto.success(clientEntities);
            }

            List<ClientEntity> clientEntities = clientRepositoy.search(search);
            return GetClientSearchResponseDto.success(clientEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<? super GetClientResponseDto> getListByOrderCategory(int clientCategory) {
        
        try {
            List<ClientEntity> clientEntities = clientRepositoy.findByClientCategory(clientCategory);
            return GetClientResponseDto.success(clientEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<? super GetClientResponseDto> getListByOrderingCategory(int clientCategory) {

        try {
            List<ClientEntity> clientEntities = clientRepositoy.findByClientCategory(clientCategory);
            return GetClientResponseDto.success(clientEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

}
