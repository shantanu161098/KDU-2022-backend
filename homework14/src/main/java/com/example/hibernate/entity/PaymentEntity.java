package com.example.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "payment")
@Data
public class PaymentEntity {
    @Id
    private Long paymentId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name="mode_of_payment")
    private String modeOfPayment;

    @Column(name="payment_details")
    private String paymentDetails;

}
