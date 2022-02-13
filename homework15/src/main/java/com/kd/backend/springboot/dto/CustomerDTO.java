package com.kd.backend.springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String city;
}
