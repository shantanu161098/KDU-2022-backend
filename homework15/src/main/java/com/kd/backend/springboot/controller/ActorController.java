package com.kd.backend.springboot.controller;
import com.kd.backend.springboot.dto.ActorDTO;
import com.kd.backend.springboot.dto.FilmDTO;
import com.kd.backend.springboot.service.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/actor")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @Value("${spring.application.name}")
    private static String applicationName;

    private final Logger logger = LoggerFactory.getLogger(ActorController.class);
    //    localhost:8081/api/actor/10
    @GetMapping("{actorId}")
    public ActorDTO getById(@PathVariable Long actorId) {
        logger.info("Received a request to fetch actor with id: {}", actorId);
        return actorService.getActorById(actorId);
    }
    //    localhost:8081/api/actor?year=2010&limit=10


    @GetMapping("/first/")
    public List<ActorDTO> getActorByFirstName(@PathParam("fname") String fname) {
        return actorService.getActorByFirstName(fname);
    }

    @GetMapping("/last/")
    public List<ActorDTO> getActorByLastName(@PathParam("lname") String lname) {
        return actorService.getActorByLastName(lname);
    }




}
