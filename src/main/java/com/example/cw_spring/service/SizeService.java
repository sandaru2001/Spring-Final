package com.example.cw_spring.service;

import com.example.cw_spring.dto.SizeDTO;
import com.example.cw_spring.entity.SizeEntity;

import java.util.List;

public interface SizeService {
    boolean saveSize(SizeDTO sizeDTO);
    boolean deleteSize(String item_code, String sizeId);
    boolean updateSize(String id, SizeDTO sizeDTO);
    List<SizeDTO> getAllSizes();
    List<String> getItemIds();
    SizeEntity getDataWithSizeAndItemID(String itemCode, String itemSize);
}
