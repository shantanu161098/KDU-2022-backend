package com.example.service;

import com.example.mapper.ActorMapper;
import com.example.jpa.ActorDaoJPA;
import com.example.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("usingActorJpa")
@Transactional("transactionManager")
public class ActorServiceJPA implements ActorService{

    @Autowired
    private ActorDaoJPA actorDao;

    @Override
    public Actor getActorById(Long id){
        return actorDao.findById(id).map(ActorMapper::fromEntity).orElse(null);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "transactionManager")
    public List<Actor> getActorByFirstName(String firstName) {
        return actorDao.findByFirstName(firstName)
                .stream()
                .map(ActorMapper::fromEntity)
                .collect(Collectors.toList());
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "transactionManager")
    public List<Actor> getActorByLastName(String lastName) {
        return actorDao.findByLastName(lastName)
                .stream()
                .map(ActorMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
