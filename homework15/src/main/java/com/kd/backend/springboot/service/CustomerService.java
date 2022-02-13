package com.kd.backend.springboot.service;

import com.kd.backend.springboot.dto.CustomerDTO;
import com.kd.backend.springboot.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getCustomerByName(String name);
    CustomerDTO getCustomerById(Long id);
    List<CustomerDTO> getCustomerByCity(String city);
}
