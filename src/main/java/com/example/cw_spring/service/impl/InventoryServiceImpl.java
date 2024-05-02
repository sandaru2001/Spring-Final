package com.example.cw_spring.service.impl;

import com.example.cw_spring.dto.InventoryDTO;
import com.example.cw_spring.entity.InventoryEntity;
import com.example.cw_spring.repository.InventoryDAO;
import com.example.cw_spring.service.InventoryService;
import com.example.cw_spring.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor

public class InventoryServiceImpl implements InventoryService {
    private final InventoryDAO inventoryDAO;
    private final Mapping mapping;
    @Override
    public InventoryDTO saveInventory(InventoryDTO employeeDTO) {
        return mapping.toInventoryDTO(inventoryDAO.save(mapping.toInventory(employeeDTO)));
    }

    @Override
    public boolean updateInventory(String id, InventoryDTO employeeDTO) {
        Optional<InventoryEntity> inventory = inventoryDAO.findById(id);
        if (inventory.isPresent()) {
            inventory.get().setItem_desc(employeeDTO.getItem_desc());
            inventory.get().setItem_picture(employeeDTO.getItem_picture());
            inventory.get().setCategory(employeeDTO.getCategory());
            inventory.get().setSize(employeeDTO.getSize());
            inventory.get().setUnit_price_sale(employeeDTO.getUnit_price_sale());
            inventory.get().setUnit_price_buy(employeeDTO.getUnit_price_buy());
            inventory.get().setExpected_profit(employeeDTO.getExpected_profit());
            inventory.get().setProfit_margin(employeeDTO.getProfit_margin());
            inventory.get().setStatus(employeeDTO.getStatus());

            return true;
        }
        return false;
    }

    @Override
    public List<InventoryDTO> getAllInventory() {
        return mapping.toInventoryDTOList(inventoryDAO.findAll());
    }

    @Override
    public boolean deleteInventory(String id) {
        inventoryDAO.deleteById(id);
        return true;
    }
}
