package com.example.cw_spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "item_code")
    private InventoryEntity inventory;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private SaleEntity sale;

    private String item_name;
    private int quantity;
    private int size;
    private double unit_price;
    private double sub_total;
}
