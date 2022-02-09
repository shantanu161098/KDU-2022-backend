package com.example.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "product_name")
    private String productName;
}
