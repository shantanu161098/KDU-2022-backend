package com.kd.backend.springboot.service;

import com.kd.backend.springboot.dto.CustomerDTO;
import com.kd.backend.springboot.mapper.CustomerListMapper;
import com.kd.backend.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerListMapper customerListMapper;

    @Override
    public List<CustomerDTO> getCustomerByName(String name) {
        return customerRepository.findByName(name).
                stream().map(customerListMapper:: fromEntity).
                collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id).map(customerListMapper:: fromEntity).orElse(null);
    }

    @Override
    public List<CustomerDTO> getCustomerByCity(String city) {
        return customerRepository.findByCity(city).
                stream().map(customerListMapper:: fromEntity).
                collect(Collectors.toList());
    }
}
