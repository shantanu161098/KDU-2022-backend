package com.example.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="adress")
@Data
public class AddressEntity implements Serializable {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name = "house_address")
    private String houseAddress;

    @Column(name = "pin_code")
    private String pinCode;
}
