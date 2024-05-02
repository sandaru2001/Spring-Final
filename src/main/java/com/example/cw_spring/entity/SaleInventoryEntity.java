package com.example.cw_spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sale_inventory")
public class SaleInventoryEntity {
    @Id
    private String order_Details_Id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "item_code")
    private InventoryEntity inventory_Entity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private SaleEntity sale_Entity;

    private String item_name;
    private int quantity;
    private double unit_cost;
    private double unit_price;
    private double sub_total;
}
