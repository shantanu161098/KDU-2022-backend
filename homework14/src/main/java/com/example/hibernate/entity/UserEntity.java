package com.example.hibernate.entity;

import com.example.model.Address;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer")
@Data
public class UserEntity implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")

    private String userName;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;




    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_address",
            joinColumns =
                    { @JoinColumn(name = "user_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "address_id", referencedColumnName = "id") })
    private AddressEntity addressJoin;

    @ManyToMany()
    private Set<ProductEntity> productEntities;

    @OneToMany(mappedBy = "user")
    private Set<OrderEntity> orderEntities;




}
