package com.example.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer_product")
@Data
public class UserProductEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Column(name = "product_id")
    private Long addressId;

}
