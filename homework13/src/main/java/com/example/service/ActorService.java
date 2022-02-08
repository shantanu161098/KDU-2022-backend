package com.example.service;

import com.example.model.Actor;

import java.util.List;

public interface ActorService {
    Actor getActorById(Long id);
    List<Actor> getActorByFirstName(String firstName);
    List<Actor> getActorByLastName(String lastName);
}
