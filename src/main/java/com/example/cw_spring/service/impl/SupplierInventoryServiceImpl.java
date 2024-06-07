package com.example.cw_spring.service.impl;

import com.example.cw_spring.entity.SupplierInventoryEntity;
import com.example.cw_spring.repository.SupplierInventoryDAO;
import com.example.cw_spring.service.SupplierInventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor

public class SupplierInventoryServiceImpl implements SupplierInventoryService {
    private SupplierInventoryDAO supplierInventoryDAO;
    @Override
    public boolean save(SupplierInventoryEntity supplierInventoryEntity) {
        SupplierInventoryEntity isSaved = supplierInventoryDAO.save(supplierInventoryEntity);
        return isSaved != null;
    }
}
