package com.kd.backend.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer_list")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
}
