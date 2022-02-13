package com.kd.backend.springboot.repository;

import com.kd.backend.springboot.entity.Actor;
import com.kd.backend.springboot.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {
    List<Actor> findByFirstName(String firstName);
    List<Actor> findByLastName(String lastName);
}