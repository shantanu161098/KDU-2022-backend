package com.example.jpa;

import com.example.hibernate.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorDaoJPA extends JpaRepository<ActorEntity,Long> {
    List<ActorEntity> findByFirstName(String firstName);
    List<ActorEntity> findByLastName(String lastName);
}
