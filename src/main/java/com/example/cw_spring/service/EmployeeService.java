package com.example.cw_spring.service;

import com.example.cw_spring.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    boolean updateEmployee(String id, EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployee();
    boolean deleteEmployee(String id);
}
