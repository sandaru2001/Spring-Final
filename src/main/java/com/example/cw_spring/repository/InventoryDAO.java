package com.example.cw_spring.repository;

import com.example.cw_spring.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryDAO extends JpaRepository<InventoryEntity, String> {
}
