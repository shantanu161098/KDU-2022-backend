package com.kd.backend.springboot.controller;

import com.kd.backend.springboot.dto.CustomerDTO;
import com.kd.backend.springboot.dto.FilmDTO;
import com.kd.backend.springboot.entity.Customer;
import com.kd.backend.springboot.service.CustomerService;
import com.kd.backend.springboot.service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Value("${spring.application.name}")
    private static String applicationName;

    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    //    localhost:8081/api/film/10
    @GetMapping("/{customerId}")
    public CustomerDTO getById(@PathVariable Long customerId) {
        logger.info("Recieved a request to fetch film with id: {}", customerId);
        return customerService.getCustomerById(customerId);
    }
    //    localhost:8081/api/film?year=2010&limit=10
    @GetMapping("/")
    public List<CustomerDTO> getAllCustomerName(@PathParam("name") String name) {
        return customerService.getCustomerByName(name);
    }
}