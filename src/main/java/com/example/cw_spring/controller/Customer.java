package com.example.cw_spring.controller;

import com.example.cw_spring.dto.CustomerDTO;
import com.example.cw_spring.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class Customer {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/health")
    public String healthTest() {
        return "Health check passed";
    }

    @PostMapping("/save")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerDTO.setCustomer_code(UUID.randomUUID().toString());
        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(customerDTO.getCustomer_code(), customerDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCustomer(@PathVariable ("id")String id) {
        return customerService.deleteCustomer(id);
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomer() {
        return customerService.getAllCustomer();
    }

}
