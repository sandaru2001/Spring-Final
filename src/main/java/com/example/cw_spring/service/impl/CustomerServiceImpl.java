package com.example.cw_spring.service.impl;

import com.example.cw_spring.dto.CustomerDTO;
import com.example.cw_spring.entity.CustomerEntity;
import com.example.cw_spring.repository.CustomerDAO;
import com.example.cw_spring.service.CustomerService;
import com.example.cw_spring.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {
    private final CustomerDAO customerDAO;
    private final Mapping mapper;
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return mapper.toCustomerDTO(customerDAO.save(mapper.toCustomer(customerDTO)));
    }

    @Override
    public boolean updateCustomer(String id, CustomerDTO customerDTO) {
        Optional<CustomerEntity> customer = customerDAO.findById(id);
        if (customer.isPresent()) {
            customer.get().setCustomer_name(customerDTO.getCustomer_name());
            customer.get().setGender(customerDTO.getGender());
            customer.get().setJoin_date(customerDTO.getJoin_date());
            customer.get().setLevel(customerDTO.getLevel());
            customer.get().setTotal_points(customerDTO.getTotal_points());
            customer.get().setDob(customerDTO.getDob());
            customer.get().setAddress_line_01(customerDTO.getAddress_line_01());
            customer.get().setAddress_line_02(customerDTO.getAddress_line_02());
            customer.get().setAddress_line_03(customerDTO.getAddress_line_03());
            customer.get().setAddress_line_04(customerDTO.getAddress_line_04());
            customer.get().setAddress_line_05(customerDTO.getAddress_line_05());
            customer.get().setContact_no(customerDTO.getContact_no());
            customer.get().setEmail(customerDTO.getEmail());
            customer.get().setPurchase_date_time(customerDTO.getPurchase_date_time());

            return true;
        }
        return false;
    }
    @Override
    public boolean deleteCustomer(String id) {
        customerDAO.deleteById(id);
        return true;

    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return mapper.toCustomerDTOList(customerDAO.findAll());
    }

}
