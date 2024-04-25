package com.example.cw_spring.controller;

import com.example.cw_spring.dto.EmployeeDTO;
import com.example.cw_spring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class Employee {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/health")
    public String healthTest() {
        return "Health check passed";
    }
    @PostMapping("/save")
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setEmployee_code(UUID.randomUUID().toString());
        return employeeService.saveEmployee(employeeDTO);
    }
}
