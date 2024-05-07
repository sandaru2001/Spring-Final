package com.example.cw_spring.controller;

import com.example.cw_spring.dto.InventoryDTO;
import com.example.cw_spring.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/inventory")

public class Inventory {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/health")
    public String healthTest() {
        return "Health check passed!";
    }

    @PostMapping("/save")
    public InventoryDTO saveInventory(InventoryDTO inventoryDTO) {
        inventoryDTO.setItem_code(UUID.randomUUID().toString());
        return inventoryService.saveInventory(inventoryDTO);
    }

    @PutMapping("/update")
    public boolean updateInventory(String id, InventoryDTO inventoryDTO) {
        return inventoryService.updateInventory(id, inventoryDTO);
    }

    @DeleteMapping("/delete")
    public boolean deleteInventory(String id) {
        return inventoryService.deleteInventory(id);
    }
    @GetMapping
    public List<InventoryDTO> getAllInventory() {
        return inventoryService.getAllInventory();
    }
}
