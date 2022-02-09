package com.example.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_payment")
@Data
public class UserPaymentEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Column(name = "payment_id")
    private Long addressId;

}
