package com.example.cw_spring.service;

import com.example.cw_spring.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    boolean saveSupplier(SupplierDTO supplierDTO);
    List<SupplierDTO> getAllSuppliers();
    boolean deleteSupplierByEmail(String email);
    boolean updateSupplierById(String supplier_code, SupplierDTO supplierDTO) throws Exception;
    SupplierDTO selectSupplierByEmail(String email);
    String generateNextID();
    List<String> getAllSupplierIds();
}
