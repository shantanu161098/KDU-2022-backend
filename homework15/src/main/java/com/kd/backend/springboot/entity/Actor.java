package com.kd.backend.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Actor {
    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    private List<Film> films;
}
