package com.example.cw_spring.controller;

import com.example.cw_spring.dto.SupplierDTO;
import com.example.cw_spring.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/supplier")
public class Supplier {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/health")
    public String health(){
        return "OK";
    }

    @PostMapping("/save")
    public boolean save(@RequestBody SupplierDTO supplierDTO){
        supplierDTO.setSupplier_code(supplierService.generateNextID());
        return supplierService.saveSupplier(supplierDTO);
    }

    @GetMapping
    public List<SupplierDTO> getAll(){
        return supplierService.getAllSuppliers();
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public boolean update(@RequestBody SupplierDTO supplierDTO) throws Exception {
        return supplierService.updateSupplierById(supplierDTO.getSupplier_code(),supplierDTO);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestPart("email") String email) {
        return supplierService.deleteSupplierByEmail(email);
    }

    @GetMapping("/selectSupplier")
    public SupplierDTO selectSupplier(String email) {
        return supplierService.selectSupplierByEmail(email);
    }

    @GetMapping("/getSupplierIds")
    public List<String> getSupplierIds(){
        return supplierService.getAllSupplierIds();
    }
}
