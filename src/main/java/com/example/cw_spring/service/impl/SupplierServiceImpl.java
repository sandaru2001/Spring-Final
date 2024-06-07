package com.example.cw_spring.service.impl;

import com.example.cw_spring.dto.SupplierDTO;
import com.example.cw_spring.entity.SupplierEntity;
import com.example.cw_spring.repository.SupplierDAO;
import com.example.cw_spring.service.SupplierService;
import com.example.cw_spring.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor

public class SupplierServiceImpl implements SupplierService {
    private final SupplierDAO supplierDAO;
    private final Mapping mapping;
    @Override
    public boolean saveSupplier(SupplierDTO supplierDTO) {
        SupplierEntity supplier = supplierDAO.save(mapping.toSupplier(supplierDTO));
        return supplier != null;
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return mapping.toSupplierDTOList(supplierDAO.findAll());
    }

    @Override
    public boolean deleteSupplierByEmail(String email) {
        Optional<SupplierEntity> supplier = supplierDAO.findByEmail(email);
        if (supplier.isPresent()) {
            supplierDAO.delete(supplier.get());
            return true;
        }else{
            throw new RuntimeException(email+" not found (:");
        }
    }

    @Override
    public boolean updateSupplierById(String supplier_code, SupplierDTO supplierDTO) {
        Optional<SupplierEntity> supplier = supplierDAO.findById(supplier_code);
        if (supplier.isPresent()) {
            supplierDAO.save(mapping.toSupplier(supplierDTO));
            return true;
        }else{
            throw new RuntimeException(supplier_code+" not found (:");
        }
    }

    @Override
    public SupplierDTO selectSupplierByEmail(String email) {
        Optional<SupplierEntity> supplier = supplierDAO.findByEmail(email);
        if (supplier.isPresent()) {
            return mapping.toSupplierDTO(supplier.get());
        }else{
            throw new RuntimeException(email+" not found (:");
        }
    }

    @Override
    public String generateNextID() {
        if (supplierDAO.findLastId() == null) {
            return "S0001";
        }
        String numericPart = supplierDAO.findLastId().substring(1);
        int lastNumericValue = Integer.parseInt(numericPart);
        int nextNumericValue = lastNumericValue + 1;
        String nextId = "S" + String.format("%04d", nextNumericValue);
        return nextId;
    }

    @Override
    public List<String> getAllSupplierIds() {
        return supplierDAO.getSupplierIds();
    }


}
