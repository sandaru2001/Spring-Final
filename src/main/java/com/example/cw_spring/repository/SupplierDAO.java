package com.example.cw_spring.repository;

import com.example.cw_spring.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierDAO extends JpaRepository<SupplierEntity, String> {
}
