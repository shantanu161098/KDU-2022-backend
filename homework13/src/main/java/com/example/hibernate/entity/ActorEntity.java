package com.example.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "actor")
@Data
public class ActorEntity {
    @Id
    @GeneratedValue
    @Column(name="actor_id")
    private Long id;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

}
