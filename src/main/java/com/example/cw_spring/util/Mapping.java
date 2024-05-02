package com.example.cw_spring.util;

import com.example.cw_spring.dto.CustomerDTO;
import com.example.cw_spring.dto.EmployeeDTO;
import com.example.cw_spring.dto.SupplierDTO;
import com.example.cw_spring.dto.UserDTO;
import com.example.cw_spring.entity.CustomerEntity;
import com.example.cw_spring.entity.EmployeeEntity;
import com.example.cw_spring.entity.SupplierEntity;
import com.example.cw_spring.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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
    public List<UserDTO> toUserDTOList(List<UserEntity> users) {
        return mapper.map(users, List.class);
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
}
