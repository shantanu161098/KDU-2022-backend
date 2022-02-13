package com.kd.backend.springboot.repository;

import com.kd.backend.springboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByName(String name);
    List<Customer> findByCity(String city);
}
