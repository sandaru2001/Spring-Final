package com.example.cw_spring.repository;

import com.example.cw_spring.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerDAO extends JpaRepository<CustomerEntity, String> {
    Optional<CustomerEntity> findByEmail(String email);
}
