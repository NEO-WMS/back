package com.example.back.service.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.back.common.util.LotCodeGenerator;
import com.example.back.dto.requset.warehouseDetail.PostWarehouseDetailCreateRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.stock.GetStockItemListResponseDto;
import com.example.back.dto.response.stock.GetStockItemResponseDto;
import com.example.back.dto.response.stock.GetStockItemSearchResponseDto;
import com.example.back.dto.response.stock.GetStockMemberListResponseDto;
import com.example.back.dto.response.stock.GetStockMemberResponseDto;
import com.example.back.dto.response.stock.GetStockMemberSearchResponseDto;
import com.example.back.repository.AreaRepository;
import com.example.back.repository.CellRepository;
import com.example.back.repository.ItemRepository;
import com.example.back.repository.MemberRepository;
import com.example.back.repository.RackRepository;
import com.example.back.repository.WarehouseDetailRepository;
import com.example.back.repository.WarehouseRepository;
import com.example.back.service.StockService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class StockServiceImplimentation implements StockService {
    
    
    private final WarehouseRepository warehouseRepository;
    private final AreaRepository areaRepository;
    private final RackRepository rackRepository;
    private final CellRepository cellRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final LotCodeGenerator lotCodeGenerator;
    private final WarehouseDetailRepository warehouseDetailRepository;
    
    
    @Override
    public ResponseEntity<ResponseDto> create(PostWarehouseDetailCreateRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ResponseEntity<? super GetStockItemListResponseDto> getItemList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItemList'");
    }

    @Override
    public ResponseEntity<? super GetStockItemSearchResponseDto> searchItem(String search) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchItem'");
    }

    @Override
    public ResponseEntity<? super GetStockItemResponseDto> getItem(int itemNo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItem'");
    }

    @Override
    public ResponseEntity<? super GetStockMemberListResponseDto> getMemberList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMemberList'");
    }

    @Override
    public ResponseEntity<? super GetStockMemberSearchResponseDto> searchMember(String search) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchMember'");
    }

    @Override
    public ResponseEntity<? super GetStockMemberResponseDto> getMember(int memberNo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMember'");
    }
    
    

}
