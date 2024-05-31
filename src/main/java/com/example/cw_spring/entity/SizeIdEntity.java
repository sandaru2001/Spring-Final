package com.example.cw_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SizeIdEntity {
    private int size;
    private InventoryEntity inventory;
}
