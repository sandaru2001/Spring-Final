package com.example.cw_spring.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SupplierInventoryEntity {
    private String supplier_inventory_id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "item_code")
    private InventoryEntity inventoryEntity;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplierEntity;
}
