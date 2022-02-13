package com.kd.backend.springboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Film {
    @Id
    @GeneratedValue
    @Column(name = "film_id")
    private Long id;

    private String title;
    private String description;

    @Column(name = "release_year")
    private Long year;
    private String rating;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    )
    private List<Actor> actors;
}
