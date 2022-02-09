package com.example.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_address")
@Data
public class UserAddressEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Column(name = "address_id")
    private Long addressId;

}
