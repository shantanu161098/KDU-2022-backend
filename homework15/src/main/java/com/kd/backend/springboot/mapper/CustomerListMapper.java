package com.kd.backend.springboot.mapper;

import com.kd.backend.springboot.dto.CustomerDTO;
import com.kd.backend.springboot.entity.Customer;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Component;

@Component
public class CustomerListMapper {
    public CustomerDTO fromEntity(Customer entity) {
        CustomerDTO customer = new CustomerDTO();

        customer.setId(entity.getId());
        customer.setName(entity.getName());
        customer.setAddress(entity.getAddress());
        customer.setCity(entity.getCity());
        return customer;
    }
}
