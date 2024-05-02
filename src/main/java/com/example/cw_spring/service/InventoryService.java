package com.example.cw_spring.service;


import com.example.cw_spring.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    InventoryDTO saveInventory(InventoryDTO employeeDTO);
    boolean updateInventory(String id, InventoryDTO employeeDTO);
    List<InventoryDTO> getAllInventory();
    boolean deleteInventory(String id);
}
