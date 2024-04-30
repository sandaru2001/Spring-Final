package com.example.cw_spring.service;

import com.example.cw_spring.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);
    boolean updateSupplier(String supplier_code, SupplierDTO supplierDTO);
    boolean deleteSupplier(String supplier_code);
    List<SupplierDTO> getAllSupplier();
}
