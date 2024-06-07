package com.example.cw_spring.util;

import com.example.cw_spring.dto.*;
import com.example.cw_spring.entity.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@RequiredArgsConstructor

public class Mapping {
    private final ModelMapper mapper;

    //CustomerMapping
    public CustomerDTO toCustomerDTO(CustomerEntity customer) {
        return  mapper.map(customer, CustomerDTO.class);
    }
    public CustomerEntity toCustomer(CustomerDTO customerDTO) {
        return  mapper.map(customerDTO, CustomerEntity.class);
    }
    public List<CustomerDTO> toCustomerDTOList(List<CustomerEntity> customers) {
        return mapper.map(customers, List.class);
    }


    //EmployeeMapping
    public EmployeeDTO toEmployeeDTO(EmployeeEntity employee) {
        return mapper.map(employee, EmployeeDTO.class);
    }
    public EmployeeEntity toEmployee(EmployeeDTO employeeDTO) {
        return mapper.map(employeeDTO, EmployeeEntity.class);
    }
    public List<EmployeeDTO> toEmployeeDTOList(List<EmployeeEntity> employees) {
        return mapper.map(employees, List.class);
    }
    //UserMapping
    public UserDTO toUserDTO(UserEntity user) {
        return mapper.map(user, UserDTO.class);
    }
    public UserEntity toUser(UserDTO userDTO) {
        return mapper.map(userDTO, UserEntity.class);
    }

    //SupplierMapping
    public SupplierDTO toSupplierDTO(SupplierEntity supplier) {
        return mapper.map(supplier, SupplierDTO.class);
    }
    public SupplierEntity toSupplier(SupplierDTO supplierDTO) {
        return mapper.map(supplierDTO, SupplierEntity.class);
    }
    public List<SupplierDTO> toSupplierDTOList(List<SupplierEntity> suppliers) {
        return mapper.map(suppliers, List.class);
    }

    //InventoryMapping
    public InventoryDTO toInventoryDTO(InventoryEntity inventory) {
        return mapper.map(inventory, InventoryDTO.class);
    }
    public InventoryEntity toInventory(InventoryDTO inventoryDTO) {
        return mapper.map(inventoryDTO, InventoryEntity.class);
    }
    public List<InventoryDTO> toInventoryDTOList(List<InventoryEntity> inventories) {
        return mapper.map(inventories, List.class);
    }

    //
    public SizeDTO toSizeDTO(SizeEntity size) {
        return  mapper.map(size, SizeDTO.class);
    }

    public SizeEntity toSize(SizeDTO sizeDTO) {
        return  mapper.map(sizeDTO, SizeEntity.class);
    }

    public List<SizeDTO> getSizeDTOList(List<SizeEntity> sizes) {
        List<SizeDTO> dtos = new ArrayList<>();
        for (SizeEntity size : sizes) {
            SizeDTO sizeDTO = new SizeDTO();
            sizeDTO.setSize(size.getSize());
            sizeDTO.setQuantity(size.getQuantity());
            sizeDTO.setUnit_price_sale(size.getUnit_price_sale());
            sizeDTO.setUnit_price_buy(size.getUnit_price_buy());
            sizeDTO.setExpected_profit(size.getExpected_profit());
            sizeDTO.setProfit_margin(size.getProfit_margin());
            sizeDTO.setItem_code(size.getInventory().getItem_code());
            sizeDTO.setStatus(size.getStatus());
            dtos.add(sizeDTO);
        }
        return dtos;
    }
}

