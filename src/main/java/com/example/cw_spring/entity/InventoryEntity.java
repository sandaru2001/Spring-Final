package com.example.cw_spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "inventory")
@Entity

public class InventoryEntity {
    @Id
    private String item_code;
    private String item_desc;
    @Column(columnDefinition = "LONGTEXT")
    private String item_picture;
    private String category;
    private int size;
    private double unit_price_sale;
    private double unit_price_buy;
    private double expected_profit;
    private double profit_margin;
    private String status;

    @OneToMany(mappedBy = "inventory_Entity")
    private Set<SaleInventoryEntity> saleInventoryEntity = new HashSet<>();
}
